package ua.com.phonebook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import ua.com.phonebook.entity.Contact;
import ua.com.phonebook.entity.CustomUser;
import ua.com.phonebook.service.ContactService;
import ua.com.phonebook.service.UserService;

import java.util.List;

/**
 * Implementation of {@link ContactService} interface to store data in JSON files.
 *
 * @author Maxim Beseda
 * @version 1.0
 */

public class ContactServiceJsonDBImpl implements ContactService {

    @Autowired
    private UserService userService;

    public CustomUser getUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = user.getUsername();

        return userService.getByLogin(login);
    }

    @Override
    public Contact addContact(Contact contact) {
        CustomUser user = getUser();
        contact.setId(user.getContacts().size());
        user.getContacts().add(contact);
        userService.editUser(user);
        return contact;
    }

    @Override
    public Contact editContact(Contact contact) {
        CustomUser user = getUser();
        int id =(int) contact.getId();
        user.getContacts().remove(id);
        user.getContacts().add(id, contact);
        userService.editUser(user);
        return contact;
    }

    @Override
    public void delete(long id) {
        CustomUser user = getUser();
        user.getContacts().remove((int)id);
        user.getContacts().add((int)id, null);
        userService.editUser(user);

    }

    @Override
    public Contact getById(long id) {
        CustomUser user = getUser();
        return user.getContacts().get((int)id);
    }

    @Override
    public Contact getByName(String name) {
        return null;
    }

    @Override
    public Contact getBySurname(String surname) {
        return null;
    }

    @Override
    public Contact getByPatronymic(String patronymic) {
        return null;
    }

    @Override
    public Contact getByMobilePhone(String mobilePhone) {
        return null;
    }

    @Override
    public Contact getByHomePhone(String homePhone) {
        return null;
    }

    @Override
    public Contact getByEmail(String email) {
        return null;
    }

    @Override
    public Contact getByAddress(String address) {
        return null;
    }

    @Override
    public List<Contact> getAll() {
        return null;
    }
}
