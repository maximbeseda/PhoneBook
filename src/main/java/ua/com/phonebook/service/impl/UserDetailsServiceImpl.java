package ua.com.phonebook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.com.phonebook.entity.CustomUser;
import ua.com.phonebook.service.UserService;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link UserDetailsService} interface.
 *
 * @author Maxim Beseda
 * @version 1.0
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        CustomUser customUser = userService.getByLogin(login);
        if (customUser == null) {
            throw new UsernameNotFoundException(login + " not found");
        }

        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(customUser.getUserRole().toString()));

        return new User(customUser.getLogin(), customUser.getPassword(), roles);
    }
}
