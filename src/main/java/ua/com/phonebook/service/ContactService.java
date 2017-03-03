package ua.com.phonebook.service;

import ua.com.phonebook.entity.Contact;

import java.util.List;


public interface ContactService {
    Contact addContact(Contact contact);
    Contact editContact(Contact contact);
    void delete (long id);
    Contact getById(long id);
    Contact getByName(String name);
    Contact getBySurname(String surname);
    Contact getByPatronymic(String patronymic);
    Contact getByMobilePhone(String mobilePhone);
    Contact getByHomePhone(String homePhone);
    Contact getByEmail(String email);
    Contact getByAddress(String address);
    List<Contact> getAll();
}
