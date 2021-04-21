package com.zuhlke.avaticaclient.avaticaclient.controller;

import com.zuhlke.avaticaclient.avaticaclient.repo.UserRepo;
import com.zuhlke.avaticaclient.avaticaclient.dto.UserDto;
import com.zuhlke.avaticaclient.avaticaclient.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/data-service")
public class UserController {

    private final UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/users")
    public Iterable<UserDto> getAllUsers() {

        final List<User> users = userRepo.findAll();
        return users.stream().map(user -> {
            UserDto dto = new UserDto();
            dto.setId(user.getId());
            dto.setName(user.getName());
            return dto;
        }).collect(Collectors.toList());
    }
}
