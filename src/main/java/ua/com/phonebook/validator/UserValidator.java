package ua.com.phonebook.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.com.phonebook.entity.CustomUser;
import ua.com.phonebook.service.UserService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validator for {@link CustomUser} class,
 * implements {@link Validator} interface.
 *
 * @author Maxim Beseda
 * @version 1.0
 */

@Component
public class UserValidator implements Validator {

    public static final Pattern VALID_LOGIN_REGEX = Pattern.compile("\\W", Pattern.CASE_INSENSITIVE);

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return CustomUser.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CustomUser user = (CustomUser) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "Required");
        if (user.getFullName().length() < 5) {
            errors.rejectValue("fullName", "Size.userForm.fullName");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "Required");
        Matcher matcher = VALID_LOGIN_REGEX.matcher(user.getLogin());
        if ((user.getLogin().length() < 3) || matcher.find()) {
            errors.rejectValue("login", "Size.userForm.login");
        }

        if (userService.getByLogin(user.getLogin()) != null) {
            errors.rejectValue("login", "Duplicate.userForm.login");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if (user.getPassword().length() < 5) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "Different.userForm.password");
        }
    }
}