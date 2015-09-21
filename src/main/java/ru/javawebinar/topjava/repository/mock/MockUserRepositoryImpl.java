package ru.javawebinar.topjava.repository.mock;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.LoggerWrapper;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * GKislin
 * 15.06.2015.
 */
@Repository
public class MockUserRepositoryImpl implements UserRepository {
    private static final LoggerWrapper LOG = LoggerWrapper.get(MockUserRepositoryImpl.class);

    private List<User> users = new CopyOnWriteArrayList<>();
    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public boolean delete(int id) {
        LOG.info("delete " + id);
        return users.remove(users.stream().filter(u -> u.getId() == id).findFirst().get());
    }

    @Override
    public User save(User user) {
        LOG.info("save " + user);
        if (user.isNew()) {
            user.setId(counter.incrementAndGet());
            users.add(user);
        } else {
            users.set(user.getId(), user);
        }
        return user;
    }

    @Override
    public User get(int id) {
        LOG.info("get " + id);
        return users.stream().filter(u -> u.getId() == id).findFirst().get();
    }

    @Override
    public List<User> getAll() {
        LOG.info("getAll");
        return users;
    }

    @Override
    public User getByEmail(String email) {
        LOG.info("getByEmail " + email);
        return users.stream().filter(u -> u.getEmail().equals(email)).findFirst().get();
    }
}
