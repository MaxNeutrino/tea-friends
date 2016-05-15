package org.glasma.teafriend.repository.mock;

import org.glasma.teafriend.UserTestData;
import org.glasma.teafriend.model.Role;
import org.glasma.teafriend.model.User;
import org.glasma.teafriend.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemoryUserRepositoryImpl implements UserRepository {

    private Map<Integer, User> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        save(new User(UserTestData.USER_ID, "user", "mail2@gmail.com", "pass2", Role.ROLE_USER));
        save(new User(UserTestData.ADMIN_ID, "admin", "mail3@gmail.com", "pass3", Role.ROLE_ADMIN));
    }

    @Override
    public User save(User user) {
        if (user.isNew())
            user.setId(counter.incrementAndGet());
        return repository.put(user.getId(), user);
    }

    @Override
    public boolean delete(int id) {
        return repository.remove(id) != null && id != 0;
    }

    @Override
    public User get(int id) {
        return repository.get(id);
    }

    @Override
    public User getByEmail(String email) {
        return getAll().stream().filter(u -> u.getEmail().equals(email)).findFirst().orElse(null);
    }

    @Override
    public Collection<User> getAll() {
        return repository.values();
    }
}
