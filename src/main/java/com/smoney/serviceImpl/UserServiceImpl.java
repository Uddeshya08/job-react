package com.smoney.serviceImpl;

import com.smoney.dto.UserRequest;
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
    public User save(UserRequest userRequest) {
        return userJpaRepository.save(User.build(0L, userRequest.getUsername(), userRequest.getFirstName(),
                userRequest.getLastName(), userRequest.getPassword(), userRequest.getRoles(), userRequest.getEmail(),
                userRequest.getMobileNo(), userRequest.getLocation(), userRequest.getSkills()));
    }

    @Override
    public Optional<User> findByUsername(String userName) {
        return userJpaRepository.findByUsername(userName);
    }




    public User findUserById(Long id) {
        return userJpaRepository.findById(id).get();
    }
}
