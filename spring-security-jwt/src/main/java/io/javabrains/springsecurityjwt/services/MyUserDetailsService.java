package io.javabrains.springsecurityjwt.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //This method will return the user by the username for this we use a hardcoded user , in practical purposes it could be from a database
        // SPring security provides the User Class it is been used here
        // THe user class constructor takes username password and authoriy list for now it will be empty;

        return new User("foo" , "foo" , new ArrayList<>());
    }
}
