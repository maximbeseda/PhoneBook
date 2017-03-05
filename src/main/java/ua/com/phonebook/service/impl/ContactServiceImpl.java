package ua.com.phonebook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.phonebook.entity.Contact;
import ua.com.phonebook.repository.ContactRepository;
import ua.com.phonebook.service.ContactService;

import java.util.List;

/**
 * Implementation of {@link ContactService} interface.
 *
 * @author Maxim Beseda
 * @version 1.0
 */

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    @Transactional
    public Contact addContact(Contact contact) {
        Contact savedContact = contactRepository.save(contact);
        return savedContact;
    }

    @Override
    @Transactional
    public Contact editContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    @Transactional
    public void delete(long id) {
        contactRepository.delete(id);
    }

    @Override
    @Transactional
    public Contact getById(long id) {
        return contactRepository.findOne(id);
    }

    @Override
    @Transactional
    public Contact getByName(String name) {
        return contactRepository.findOrderByName(name);
    }

    @Override
    @Transactional
    public Contact getBySurname(String surname) {
        return contactRepository.findOrderBySurname(surname);
    }

    @Override
    @Transactional
    public Contact getByPatronymic(String patronymic) {
        return contactRepository.findOrderByPatronymic(patronymic);
    }

    @Override
    @Transactional
    public Contact getByMobilePhone(String mobilePhone) {
        return contactRepository.findOrderByMobilePhone(mobilePhone);
    }

    @Override
    @Transactional
    public Contact getByHomePhone(String homePhone) {
        return contactRepository.findOrderByHomePhone(homePhone);
    }

    @Override
    @Transactional
    public Contact getByEmail(String email) {
        return contactRepository.findOrderByEmail(email);
    }

    @Override
    @Transactional
    public Contact getByAddress(String address) {
        return contactRepository.findOrderByAddress(address);
    }

    @Override
    @Transactional
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }
}
