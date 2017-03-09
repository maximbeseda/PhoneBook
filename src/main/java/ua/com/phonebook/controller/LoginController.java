package ua.com.phonebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for login page.
 *
 * @author Maxim Beseda
 * @version 1.0
 */

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    @RequestMapping
    public String login(Model model, String error) {
        if (error != null) {
            model.addAttribute("error", "Неправильный логин или пароль");
        }

        return "login";
    }
}
