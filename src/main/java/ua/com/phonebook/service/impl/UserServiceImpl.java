package ua.com.phonebook.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.phonebook.entity.CustomUser;
import ua.com.phonebook.entity.enums.UserRole;
import ua.com.phonebook.repository.UserRepository;
import ua.com.phonebook.service.UserService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Implementation of {@link UserService} interface.
 *
 * @author Maxim Beseda
 * @version 1.0
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public CustomUser addUser(CustomUser customUser) {
        customUser.setPassword(sha1(customUser.getPassword()));
        customUser.setUserRole(UserRole.USER);
        userRepository.save(customUser);
        return customUser;
    }

    @Override
    @Transactional
    public CustomUser editUser(CustomUser customUser) {
        customUser.setPassword(sha1(customUser.getPassword()));
        userRepository.save(customUser);
        return customUser;
    }

    @Override
    @Transactional
    public void delete(long id) {
        userRepository.delete(id);
    }

    @Override
    @Transactional
    public CustomUser getById(long id) {
        return userRepository.findOne(id);
    }

    @Override
    @Transactional
    public CustomUser getByFullName(String fullName) {
        return userRepository.findOrderByFullName(fullName);
    }

    @Override
    @Transactional
    public CustomUser getByLogin(String login) {
        return userRepository.findOrderByLogin(login);
    }

    @Override
    @Transactional
    public List<CustomUser> getAll() {
        return userRepository.findAll();
    }

    public String sha1(String input) {
        MessageDigest mDigest = null;
        try {
            mDigest = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }
}
