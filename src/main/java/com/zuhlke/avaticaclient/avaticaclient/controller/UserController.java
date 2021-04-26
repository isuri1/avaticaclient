package com.zuhlke.avaticaclient.avaticaclient.controller;

import com.zuhlke.avaticaclient.avaticaclient.repo.UserRepo;
import com.zuhlke.avaticaclient.avaticaclient.dto.UserDto;
import com.zuhlke.avaticaclient.avaticaclient.model.User;
import com.zuhlke.avaticaclient.avaticaclient.service.IUserService;
import com.zuhlke.avaticaclient.avaticaclient.service.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/data-service")
public class UserController {

    private final UserRepo userRepo;
    private final IUserService userService;

    public UserController(UserRepo userRepo, IUserService userService) {
        this.userRepo = userRepo;
        this.userService = userService;
    }

    @GetMapping("/users")
    public Iterable<UserDto> getAllUsers() {

        final List<User> users = userRepo.findAll();
        return users.stream().map(user -> {
            ModelMapper modelMapper = new ModelMapper();
            UserDto userDto = modelMapper.map(user, UserDto.class);
            return userDto;
        }).collect(Collectors.toList());
    }

    @PutMapping("/users/{id}")
    public UserDto updateUser(@RequestBody User user, @PathVariable Long id) {

        final UserDto userDto = userService.updateUser(user, id);
        return userDto;
    }

    @PostMapping("/users")
    User createUser(@RequestBody User newUser) {
        return userRepo.save(newUser);
    }
}
