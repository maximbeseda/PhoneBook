package ua.com.phonebook.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.phonebook.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findOrderByFullName (String fullName);
    User findOrderByLogin (String login);
}
