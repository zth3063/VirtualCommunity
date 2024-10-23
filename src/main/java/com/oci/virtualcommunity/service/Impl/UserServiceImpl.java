package com.oci.virtualcommunity.service.Impl;

import com.oci.virtualcommunity.entity.User;
import com.oci.virtualcommunity.repository.UserRepository;
import com.oci.virtualcommunity.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    UserRepository userRepository;
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User select(Integer userId) {
        Optional<User> byId = userRepository.findById(userId);
        return byId.orElse(null);
    }

    @Override
    public User selectByName(String name) {
        return userRepository.selectByName(name);
    }

    @Override
    public void delete(Integer userId) {
        userRepository.deleteById(userId);
    }
}
