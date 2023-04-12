package com.smoney.serviceImpl;

import com.smoney.entity.User;
import com.smoney.repository.UserJpaRepository;
import com.smoney.repositoryImpl.UserRepositoryImpl;
import com.smoney.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private UserRepositoryImpl userRepositoryImpl;

    @Override
    public User save(User user) {
        return userJpaRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(User user) {
        return userJpaRepository.findByUsername(user.getUsername());
    }
}
