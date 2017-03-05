package ua.com.phonebook.entity;

import javax.persistence.*;

/**
 * Simple JavaBean object that represents a Contact of {@link CustomUser}.
 *
 * @author Maxim Beseda
 * @version 1.0
 */

@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String patronymic;

    @Column(nullable = false)
    private String mobilePhone;

    private String homePhone;
    private String email;
    private String address;

    @ManyToOne
    @JoinColumn(name = "customUser_id", nullable = false)
    private CustomUser customUser;

    public Contact() {
    }

    public Contact(String surname, String name, String patronymic, String mobilePhone, CustomUser customUser) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.mobilePhone = mobilePhone;
        this.customUser = customUser;
    }

    public Contact(String surname, String name, String patronymic, String mobilePhone, String homePhone,
                   String email, String address, CustomUser customUser) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.mobilePhone = mobilePhone;
        this.homePhone = homePhone;
        this.email = email;
        this.address = address;
        this.customUser = customUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomUser getCustomUser() {
        return customUser;
    }

    public void setCustomUser(CustomUser customUser) {
        this.customUser = customUser;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", customUser=" + customUser +
                '}';
    }
}
