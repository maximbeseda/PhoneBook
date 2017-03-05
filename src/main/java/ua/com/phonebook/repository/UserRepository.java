package ua.com.phonebook.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.phonebook.entity.CustomUser;

public interface UserRepository extends JpaRepository<CustomUser, Long> {
    CustomUser findOrderByFullName (String fullName);
    CustomUser findOrderByLogin (String login);
}
