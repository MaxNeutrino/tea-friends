package org.glasma.teafriend.service.impl;

import org.glasma.teafriend.model.TeaRate;
import org.glasma.teafriend.repository.TeaRateRepository;
import org.glasma.teafriend.service.TeaRateService;
import org.glasma.teafriend.util.exception.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeaRateServiceImpl implements TeaRateService {

    @Autowired
    TeaRateRepository repository;

    @Override
    public TeaRate setRate(TeaRate rate, int userId, int teaId) {
        return repository.setRate(rate, userId, teaId);
    }

    @Override
    public void delete(int id) {
        ExceptionUtil.check(repository.delete(id), id);
    }

    @Override
    public void deleteAll(int teaId) {
        ExceptionUtil.check(repository.deleteAll(teaId), teaId);
    }

    @Override
    public List<TeaRate> getAllByTea(int teaId) {
        return repository.getAllByTea(teaId);
    }
}
