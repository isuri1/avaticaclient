package com.zuhlke.avaticaclient.avaticaclient.repo;

import com.zuhlke.avaticaclient.avaticaclient.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserRepo extends JpaRepository<User, Long> {

    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    @Override
    List<User> findAll();
}
