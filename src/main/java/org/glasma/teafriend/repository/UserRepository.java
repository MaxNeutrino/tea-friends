package org.glasma.teafriend.repository;

import org.glasma.teafriend.model.Tea;
import org.glasma.teafriend.model.User;

import java.util.Collection;
import java.util.List;

public interface UserRepository {

    User save(User user);

    boolean delete(int id);

    User get(int id);

    User getByEmail(String email);

    Collection<User> getAll();

    void saveWishTeaList(int id, List<Tea> wishList);

    void saveDrunkTeaList(int id, List<Tea> drunkList);
}
