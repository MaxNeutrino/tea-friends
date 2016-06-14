package org.glasma.teafriend.service;

import org.glasma.teafriend.model.Tea;
import org.glasma.teafriend.model.User;
import org.glasma.teafriend.util.exception.NotFoundException;

import java.util.Collection;
import java.util.List;

public interface UserService {

    User save(User user);

    void delete(int id) throws NotFoundException;

    User update(User user) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    Collection<User> getAll();

    List<Tea> getWishTeaList(int id);

    void saveWishTeaList(int id, int teaId);

    void removeTeaFromWishTeaList(int userId, int teaId);

    List<Tea> getDrunkTeaList(int id);

    void setTeaToDrunkTeaList(int userId, int drunkTeaId, int rate);

    void removeTeaFromDrunkTeaList(int userId, int drunkTeaId);
}
