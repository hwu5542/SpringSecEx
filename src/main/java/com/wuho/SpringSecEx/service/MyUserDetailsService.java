package com.wuho.SpringSecEx.service;

import com.wuho.SpringSecEx.model.UserPrincipal;
import com.wuho.SpringSecEx.model.Users;
import com.wuho.SpringSecEx.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = null;
        try {
            user = repo.findByUsername(username);
            if (user == null) {
                System.out.println("User Not Found");
                throw new UsernameNotFoundException("User Not Found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return new UserPrincipal(user);
    }
}
