package ua.com.phonebook.service;

/**
 * Service for Security.
 *
 * @author Maxim Beseda
 * @version 1.0
 */

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
