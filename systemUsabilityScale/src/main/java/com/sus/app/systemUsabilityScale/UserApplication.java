package com.sus.app.systemUsabilityScale;

import com.sus.app.systemUsabilityScale.models.User;
import com.sus.app.systemUsabilityScale.services.Dao;
import com.sus.app.systemUsabilityScale.services.JpaUserDao;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class UserApplication {
    private static JpaUserDao jpaUserDao;

    public static void main(String[] args) {
        User user1 = getUser(1);
        System.out.println(user1);
        updateUser(user1, new String[]{"Jake", "jake@domain.com"});
        saveUser(getUser(2));
        deleteUser(getUser(2));
        getAllUsers().forEach(user -> System.out.println(user.getName()));
    }

    public static User getUser(long id) {
        Optional<User> user = jpaUserDao.get(id);

        return user.orElseGet(
                () -> new User("non-existing user", "no-email"));
    }

    public static List<User> getAllUsers() {
        return jpaUserDao.getAll();
    }

    public static void updateUser(User user, String[] params) {
        jpaUserDao.update(user, params);
    }

    public static void saveUser(User user) {
        jpaUserDao.save(user);
    }

    public static void deleteUser(User user) {
        jpaUserDao.delete(user);
    }
}
