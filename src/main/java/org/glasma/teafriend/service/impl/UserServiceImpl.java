package org.glasma.teafriend.service.impl;

import org.glasma.teafriend.model.Tea;
import org.glasma.teafriend.model.User;
import org.glasma.teafriend.repository.UserRepository;
import org.glasma.teafriend.service.UserService;
import org.glasma.teafriend.util.exception.ExceptionUtil;
import org.glasma.teafriend.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

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
    public void saveWishTeaList(int id, List<Tea> wishList) {
        repository.saveWishTeaList(id, wishList);
    }

    @Override
    public List<Tea> getDrunkTeaList(int id) {
        return get(id).getDrunkTeaList();
    }

    @Override
    public void saveDrunkTeaList(int id, List<Tea> drunkTea) {
        repository.saveDrunkTeaList(id, drunkTea);
    }
}
