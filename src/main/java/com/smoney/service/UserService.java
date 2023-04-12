package com.smoney.service;

import com.smoney.entity.User;

import java.util.Optional;

public interface UserService {

    public User save(User user);

    public Optional<User> findByUsername(User user);

}
