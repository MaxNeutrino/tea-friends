package org.glasma.teafriend.service.impl;

import org.glasma.teafriend.LoggerWrapper;
import org.glasma.teafriend.model.Tea;
import org.glasma.teafriend.model.TeaRate;
import org.glasma.teafriend.model.User;
import org.glasma.teafriend.repository.TeaRateRepository;
import org.glasma.teafriend.repository.TeaRepository;
import org.glasma.teafriend.repository.UserRepository;
import org.glasma.teafriend.service.UserService;
import org.glasma.teafriend.util.exception.ExceptionUtil;
import org.glasma.teafriend.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final static LoggerWrapper LOG = LoggerWrapper.get(UserServiceImpl.class);

    @Autowired
    private UserRepository repository;

    @Autowired
    private TeaRepository teaRepository;

    @Autowired
    private TeaRateRepository rateRepository;

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(int id) {
        ExceptionUtil.check(repository.delete(id), id);
    }

    @Override
    public User update(User user) {
        return repository.save(user);
    }

    @Override
    public User get(int id) throws NotFoundException {
        return ExceptionUtil.check(repository.get(id), id);
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        return ExceptionUtil.check(repository.getByEmail(email), "email=" + email);
    }

    @Override
    public Collection<User> getAll() {
        return repository.getAll();
    }

    @Override
    public List<Tea> getWishTeaList(int id) {
        return get(id).getWishTeaList();
    }

    @Override
    public void saveWishTeaList(int userId, int teaId) {
        List<Tea> wishList = getWishTeaList(userId);
        wishList.add(teaRepository.get(teaId));
        repository.saveWishTeaList(userId, wishList);
    }

    @Override
    public void removeTeaFromWishTeaList(int userId, int teaId) {
        List<Tea> wishList = getWishTeaList(userId);
        wishList.remove(teaRepository.get(teaId));
        repository.saveWishTeaList(userId, wishList);
    }

    @Override
    public List<Tea> getDrunkTeaList(int id) {
        return get(id).getDrunkTeaList();
    }

    @Override
    public void setTeaToDrunkTeaList(int userId, int drunkTeaId, int rate) {
        Tea tea = teaRepository.get(drunkTeaId);

        TeaRate teaRate = new TeaRate(rate, repository.get(userId), tea);
        rateRepository.setRate(teaRate, userId, drunkTeaId);

        List<Tea> drunkTea = getDrunkTeaList(userId);
        drunkTea.add(tea);
        repository.saveDrunkTeaList(userId, drunkTea);
        int countConnoisseurs = tea.getCountConnoisseurs() + 1;


        tea.setRate(calculateMiddleRate(drunkTeaId, countConnoisseurs));
        tea.setCountConnoisseurs(countConnoisseurs);
        teaRepository.save(tea);
    }

    @Override
    public void removeTeaFromDrunkTeaList(int userId, int drunkTeaId) {
        rateRepository.delete(rateRepository.get(userId, drunkTeaId).getId());
        Tea tea = teaRepository.get(drunkTeaId);
        int countConnoisseurs = tea.getCountConnoisseurs() - 1;
        tea.setRate(calculateMiddleRate(drunkTeaId, countConnoisseurs));
        tea.setCountConnoisseurs(countConnoisseurs);
        tea = teaRepository.save(tea);

        List<Tea> drunkTea = getDrunkTeaList(userId);
        drunkTea.remove(tea);

        repository.saveDrunkTeaList(userId, drunkTea);
    }

    private double calculateMiddleRate(int teaId, int countConnoisseurs) {
        List<TeaRate> teaRateList = rateRepository.getAllByTea(teaId);
        double userSumRate = teaRateList.stream().collect(Collectors.summingInt(TeaRate::getRate));
        return userSumRate / (double) countConnoisseurs;
    }
}
