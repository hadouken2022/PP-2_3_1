package web_hibernate.dao;

import web_hibernate.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    User getUser(int id);

    List<User> listUsers();

    void deleteUser(int id);
}
