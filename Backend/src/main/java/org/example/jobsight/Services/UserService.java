package org.example.jobsight.Services;

import org.example.jobsight.Models.User;
import org.example.jobsight.Repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByName(String username) {
        return userRepository.findByName(username);
    }
}
