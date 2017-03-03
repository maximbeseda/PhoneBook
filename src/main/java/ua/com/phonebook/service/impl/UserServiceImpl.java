package ua.com.phonebook.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.phonebook.entity.User;
import ua.com.phonebook.repository.UserRepository;
import ua.com.phonebook.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User addContact(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    @Transactional
    public User editContact(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(long id) {
        userRepository.delete(id);
    }

    @Override
    @Transactional
    public User getById(long id) {
        return userRepository.findOne(id);
    }

    @Override
    @Transactional
    public User getByFullName(String fullName) {
        return userRepository.findOrderByFullName(fullName);
    }

    @Override
    @Transactional
    public User getByLogin(String login) {
        return userRepository.findOrderByLogin(login);
    }

    @Override
    @Transactional
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
