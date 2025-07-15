package org.example.jobsight.Controllers;

import org.example.jobsight.Models.User;
import org.example.jobsight.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public User findByName(String username) {
        return userService.findByName(username);
    }
}
