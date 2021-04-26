package com.zuhlke.avaticaclient.avaticaclient.service;

import com.zuhlke.avaticaclient.avaticaclient.dto.UserDto;
import com.zuhlke.avaticaclient.avaticaclient.model.User;
import com.zuhlke.avaticaclient.avaticaclient.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDto updateUser(User user, Long id){

        final Optional<User> existingUser = userRepo.findById(id);
        if(!existingUser.isPresent()){
            return null;
        }else {
            User updatedUser = existingUser.get();
            updatedUser.setId(user.getId());
            updatedUser.setName(user.getName());
            userRepo.save(updatedUser);

            ModelMapper modelMapper = new ModelMapper();
            UserDto userDto = modelMapper.map(user, UserDto.class);
            return userDto;
//        throw new RuntimeException();
        }
    }
}
