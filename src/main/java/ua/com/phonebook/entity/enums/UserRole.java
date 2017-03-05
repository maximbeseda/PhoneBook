package ua.com.phonebook.entity.enums;

import ua.com.phonebook.entity.CustomUser;

/**
 * Enum that represents role of {@link CustomUser}.
 *
 * @author Maxim Beseda
 * @version 1.0
 */
public enum UserRole {
    USER, ADMIN;

    @Override
    public String toString() {
        return "ROLE_" + name();
    }
}
