package ua.com.phonebook.controller;

import org.springframework.stereotype.Controller;
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
    public String loginPage() {
        return "login";
    }
}
