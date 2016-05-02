package org.glasma.teafriend.service;

import org.glasma.teafriend.model.User;
import org.glasma.teafriend.util.exception.NotFoundException;

import java.util.Collection;

public interface UserService {

    User save(User user);

    void delete(int id) throws NotFoundException;

    User update(User user) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    Collection<User> getAll();
}
