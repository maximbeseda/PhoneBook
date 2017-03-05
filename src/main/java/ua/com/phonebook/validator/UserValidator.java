package ua.com.phonebook.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.com.phonebook.entity.CustomUser;
import ua.com.phonebook.service.UserService;

/**
 * Validator for {@link CustomUser} class,
 * implements {@link Validator} interface.
 *
 * @author Maxim Beseda
 * @version 1.0
 */

@Component
@PropertySource("classpath:validation.properties")
public class UserValidator implements Validator {

    @Value("${Required}")
    private String required;
    @Value("${Size.userForm.fullName}")
    private String sizeFullName;
    @Value("${Size.userForm.login}")
    private String sizeLogin;
    @Value("${Duplicate.userForm.login}")
    private String duplicateLogin;
    @Value("${Size.userForm.password}")
    private String sizePassword;
    @Value("${Different.userForm.password}")
    private String differentPassword;


    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return CustomUser.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CustomUser user = (CustomUser) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", required);
        if (user.getFullName().length() < 5) {
            errors.rejectValue("fullName", sizeFullName);
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", required);
        if ((user.getLogin().length() < 3) && user.getLogin().matches("^[a-zA-Z]+$")) {
            errors.rejectValue("login", sizeLogin);
        }

        if (userService.getByLogin(user.getLogin()) != null) {
            errors.rejectValue("login", duplicateLogin);
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", required);
        if (user.getPassword().length() < 5) {
            errors.rejectValue("password", sizePassword);
        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", differentPassword);
        }
    }
}