package org.glasma.teafriend.service.impl;

import org.glasma.teafriend.model.User;
import org.glasma.teafriend.repository.UserRepository;
import org.glasma.teafriend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public User update(User user) {
        return repository.save(user);
    }

    @Override
    public User get(int id) {
        return repository.get(id);
    }

    @Override
    public User getByEmail(String email) {
        return repository.getByEmail(email);
    }

    @Override
    public Collection<User> getAll() {
        return getAll();
    }
}
