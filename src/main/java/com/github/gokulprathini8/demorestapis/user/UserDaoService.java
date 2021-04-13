package com.github.gokulprathini8.demorestapis.user;

import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Repository
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static int usersCount = 3;

    static {
        users.add(new User(1, "Person 1", new Date()));
        users.add(new User(2, "Person 2", new Date()));
        users.add(new User(3, "Person 3", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for(User user: users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

}
