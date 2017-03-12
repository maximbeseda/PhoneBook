package ua.com.phonebook.entity;


import ua.com.phonebook.entity.enums.UserRole;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple JavaBean object that represents a User.
 *
 * @author Maxim Beseda
 * @version 1.0
 */

@Entity
@Table(name = "users")
public class CustomUser {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password;

    @Transient
    private String confirmPassword;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @OneToMany(mappedBy = "customUser", cascade = CascadeType.ALL)
    private List<Contact> contacts = new ArrayList<>();

    public CustomUser() {
    }

    public CustomUser(String fullName, String login, String password, UserRole userRole) {
        this.fullName = fullName;
        this.login = login;
        this.password = password;
        this.userRole = userRole;
    }

    public CustomUser(String fullName, String login, String password, UserRole userRole, List<Contact> contacts) {
        this.fullName = fullName;
        this.login = login;
        this.password = password;
        this.userRole = userRole;
        this.contacts = contacts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "CustomUser{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", userRole=" + userRole +
                ", contacts=" + contacts +
                '}';
    }
}
