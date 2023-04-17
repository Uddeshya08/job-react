package com.smoney.service;

import com.smoney.dto.UserRequest;
import com.smoney.entity.User;

import java.util.Optional;

public interface UserService {

    public User save(UserRequest user);

    public Optional<User> findByUsername(String userName);

    public User findUserById(Long id);

}
