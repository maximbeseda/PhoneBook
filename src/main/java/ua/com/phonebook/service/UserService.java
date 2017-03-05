package ua.com.phonebook.service;

import ua.com.phonebook.entity.CustomUser;

import java.util.List;

/**
 * Service class for {@link CustomUser}
 *
 * @author Maxim Beseda
 * @version 1.0
 */

public interface UserService {
    CustomUser addUser(CustomUser customUser);
    CustomUser editUser(CustomUser customUser);
    void delete (long id);
    CustomUser getById(long id);
    CustomUser getByFullName(String fullName);
    CustomUser getByLogin(String login);
    List<CustomUser> getAll();
}
