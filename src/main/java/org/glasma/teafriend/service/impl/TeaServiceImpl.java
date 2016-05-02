package org.glasma.teafriend.service.impl;

import org.glasma.teafriend.model.Tea;
import org.glasma.teafriend.repository.TeaRepository;
import org.glasma.teafriend.service.TeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TeaServiceImpl implements TeaService {

    @Autowired
    TeaRepository repository;

    @Override
    public Tea save(Tea tea) {
        return repository.save(tea);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public Tea update(Tea tea) {
        return repository.save(tea);
    }

    @Override
    public Tea get(int id) {
        return repository.get(id);
    }

    @Override
    public Collection<Tea> getAll() {
        return repository.getAll();
    }
}
