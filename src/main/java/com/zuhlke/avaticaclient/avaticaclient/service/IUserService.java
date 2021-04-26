package com.zuhlke.avaticaclient.avaticaclient.service;

import com.zuhlke.avaticaclient.avaticaclient.dto.UserDto;
import com.zuhlke.avaticaclient.avaticaclient.model.User;

public interface IUserService {
    UserDto updateUser(User user, Long id);
}
