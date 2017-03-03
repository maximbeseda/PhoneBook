package ua.com.phonebook.service;

import ua.com.phonebook.entity.User;

import java.util.List;


public interface UserService {
    User addContact(User user);
    User editContact(User user);
    void delete (long id);
    User getById(long id);
    User getByFullName(String fullName);
    User getByLogin(String login);
    List<User> getAll();
}
