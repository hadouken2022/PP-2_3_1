package web_hibernate.service;

import web_hibernate.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    User getUser(int id);

    List<User> listUsers();

    void deleteUser(int id);
}
