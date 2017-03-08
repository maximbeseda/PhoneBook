package ua.com.phonebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import ua.com.phonebook.entity.CustomUser;
import ua.com.phonebook.service.SecurityService;
import ua.com.phonebook.service.UserService;
import ua.com.phonebook.validator.UserValidator;

/**
 * Controller for {@link CustomUser}'s pages.
 *
 * @author Maxim Beseda
 * @version 1.0
 */

@Controller
@SessionAttributes("userForm")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;


    public CustomUser getUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = user.getUsername();

        return userService.getByLogin(login);
    }

    @RequestMapping(value = {"/", "/contacts"})
    public String contacts (Model model){
        CustomUser user = getUser();
        model.addAttribute("fullName", user.getFullName());
        model.addAttribute("login", user.getLogin());
        model.addAttribute("roles", user.getUserRole());
        model.addAttribute("allContacts", user.getContacts());

        return "contacts";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new CustomUser());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") CustomUser userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.addUser(userForm);
        securityService.autoLogin(userForm.getLogin(), userForm.getConfirmPassword());

        return "redirect:/";
    }

}
