package com.exp.service;

import com.exp.service.dtos.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private static Map<String, User> testRepo = new HashMap();

    static {
        User honey = new User();
        honey.setId("1");
        honey.setName("A");
        testRepo.put(honey.getId(), honey);

        User almond = new User();
        almond.setId("2");
        almond.setName("B");
        testRepo.put(almond.getId(), almond);
    }

    @Override
    public void createUser(User user) {
        testRepo.put(user.getId(), user);
    }

    @Override
    public void updateUser(String id, User user) {
        testRepo.remove(id);
        user.setId(id);
        testRepo.put(id, user);
    }

    @Override
    public void deleteUser(String id) {
        testRepo.remove(id);

    }

    @Override
    public Collection<User> getUsers() {
        return testRepo.values();
    }
}
