package ua.com.phonebook.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.com.phonebook.entity.Contact;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validator for {@link Contact} class,
 * implements {@link Validator} interface.
 *
 * @author Maxim Beseda
 * @version 1.0
 */

@Component
public class ContactValidator implements Validator {

    private final Pattern VALID_EMAIL_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private final Pattern VALID_PHONE_REGEX = Pattern.compile("^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$");

    @Override
    public boolean supports(Class<?> aClass) {
        return Contact.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Contact contact = (Contact) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "Required");
        if (contact.getSurname().length() < 4) {
            errors.rejectValue("surname", "Size.contactForm.surname");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");
        if (contact.getName().length() < 4) {
            errors.rejectValue("name", "Size.contactForm.name");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "patronymic", "Required");
        if (contact.getPatronymic().length() < 4) {
            errors.rejectValue("patronymic", "Size.contactForm.patronymic");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobilePhone", "Required");
        Matcher matcher = VALID_PHONE_REGEX.matcher(contact.getMobilePhone());
        if (!matcher.find()) {
            errors.rejectValue("mobilePhone", "Incorrect.contactForm.mobilePhone");
        }

        matcher = VALID_PHONE_REGEX.matcher(contact.getHomePhone());
        if (!contact.getHomePhone().equals("") && !matcher.find()) {
            errors.rejectValue("homePhone", "Incorrect.contactForm.homePhone");
        }

        matcher = VALID_EMAIL_REGEX.matcher(contact.getEmail());
        if (!contact.getEmail().equals("") && !matcher.find()) {
            errors.rejectValue("email", "Incorrect.contactForm.email");
        }

    }
}
