package com.sus.app;

import com.sus.app.systemUsabilityScale.config.JpaEntityManagerFactory;
import com.sus.app.systemUsabilityScale.models.User;
import com.sus.app.systemUsabilityScale.services.Dao;
import com.sus.app.systemUsabilityScale.services.JpaUserDao;

import java.util.List;
import java.util.Optional;

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

    private static class JpaUserDaoHolder {
        private static final JpaUserDao jpaUserDao = new JpaUserDao(new JpaEntityManagerFactory().getEntityManager());
    }

    public static Dao getJpaUserDao() {
        return JpaUserDaoHolder.jpaUserDao;
    }

    public static User getUser(long id) {
        Optional<User> user = getJpaUserDao().get(id);

        return user.orElseGet(
                () -> {
                    return new User("non-existing user", "no-email");
                });
    }

    public static List<User> getAllUsers() {
        return getJpaUserDao().getAll();
    }

    public static void updateUser(User user, String[] params) {
        getJpaUserDao().update(user, params);
    }

    public static void saveUser(User user) {
        getJpaUserDao().save(user);
    }

    public static void deleteUser(User user) {
        getJpaUserDao().delete(user);
    }
}
