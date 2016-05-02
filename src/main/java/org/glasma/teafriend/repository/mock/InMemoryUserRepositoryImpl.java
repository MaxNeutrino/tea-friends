package org.glasma.teafriend.repository.mock;

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
        save(new User(44, "user1", "mail1@gmail.com", "pass1", true, Role.ROLE_ADMIN));
        save(new User(45, "user2admin", "mail2@gmail.com", "pass2", true, Role.ROLE_USER));
        save(new User(46, "user3", "mail3@gmail.com", "pass3", false,  Role.ROLE_USER));
    }

    @Override
    public User save(User user) {
        if (user.isNew())
            user.setId(counter.incrementAndGet());
        return repository.put(user.getId(), user);
    }

    @Override
    public boolean delete(int id) {
        return repository.remove(id) != null;
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
