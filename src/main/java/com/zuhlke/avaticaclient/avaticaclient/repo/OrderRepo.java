package com.zuhlke.avaticaclient.avaticaclient.repo;

import com.zuhlke.avaticaclient.avaticaclient.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface OrderRepo extends JpaRepository<Order, Long> {

//    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    @Override
    List<Order> findAll();

}
