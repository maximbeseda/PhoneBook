package ua.com.phonebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.phonebook.entity.Contact;
import ua.com.phonebook.entity.CustomUser;
import ua.com.phonebook.service.ContactService;
import ua.com.phonebook.service.UserService;
import ua.com.phonebook.validator.ContactValidator;

/**
 * Controller for {@link Contact}'s pages.
 *
 * @author Maxim Beseda
 * @version 1.0
 */

@Controller
public class ContactController {

    @Autowired
    private UserService userService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private ContactValidator contactValidator;

    public CustomUser getUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = user.getUsername();

        return userService.getByLogin(login);
    }

    @RequestMapping(value = "/contact_add", method = RequestMethod.GET)
    public String contactAdd(Model model) {
        model.addAttribute("fullName", getUser().getFullName());
        model.addAttribute("contactForm", new Contact());

        return "contact_add";
    }

    @RequestMapping(value = "/contact_add", method = RequestMethod.POST)
    public String contactAdd(@ModelAttribute("contactForm") Contact contactForm, BindingResult bindingResult, Model model) {
        contactValidator.validate(contactForm, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("fullName", getUser().getFullName());
            return "contact_add";
        }
        contactForm.setCustomUser(getUser());
        contactService.addContact(contactForm);
        model.addAttribute("allContacts", getUser().getContacts());

        return "redirect:/";
    }

    @RequestMapping(value = "/contact_edit", method = RequestMethod.POST)
    public String contactEdit(@RequestParam(value = "toUpdate", required = false) Long toUpdate, Model model) {
        model.addAttribute("fullName", getUser().getFullName());
        model.addAttribute("id", toUpdate);
        model.addAttribute("editContactForm", contactService.getById(toUpdate));

        return "contact_edit";
    }

    @RequestMapping(value = "/contact_update", method = RequestMethod.POST)
    public String contactUpdate(@ModelAttribute("editContactForm") Contact contactForm, BindingResult bindingResult,
                                Model model) {
        contactValidator.validate(contactForm, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("fullName", getUser().getFullName());
            return "contact_edit";
        }
        contactForm.setCustomUser(getUser());
        contactService.editContact(contactForm);

        return "redirect:/";
    }

    @RequestMapping(value = "/contact_delete", method = RequestMethod.POST)
    public ResponseEntity<Void> contactDelete(@RequestParam(value = "toDelete", required = false) Long toDelete, Model model) {
        contactService.delete(toDelete);
        model.addAttribute("allContacts", contactService.getAll());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
