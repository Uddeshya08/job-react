package com.smoney.service;

import com.smoney.entity.MyUserDetails;
import com.smoney.entity.User;
import com.smoney.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SmoneyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userJpaRepository.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("User not found for the given username" + username));
        return user.map(MyUserDetails::new).get();
    }
}
