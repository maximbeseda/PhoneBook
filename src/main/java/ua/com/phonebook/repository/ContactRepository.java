package ua.com.phonebook.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.phonebook.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    Contact findOrderByName (String name);
    Contact findOrderBySurname (String surname);
    Contact findOrderByPatronymic (String patronymic);
    Contact findOrderByMobilePhone (String mobilePhone);
    Contact findOrderByHomePhone (String homePhone);
    Contact findOrderByEmail (String email);
    Contact findOrderByAddress (String address);

}
