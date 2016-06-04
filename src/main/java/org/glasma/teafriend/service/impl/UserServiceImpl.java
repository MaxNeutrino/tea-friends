package org.glasma.teafriend.service.impl;

import org.glasma.teafriend.model.User;
import org.glasma.teafriend.repository.UserRepository;
import org.glasma.teafriend.service.UserService;
import org.glasma.teafriend.util.exception.ExceptionUtil;
import org.glasma.teafriend.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

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
}
