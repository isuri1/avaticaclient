package com.zuhlke.avaticaclient.avaticaclient.controller;

import com.zuhlke.avaticaclient.avaticaclient.repo.OrderRepo;
import com.zuhlke.avaticaclient.avaticaclient.dto.OrderDto;
import com.zuhlke.avaticaclient.avaticaclient.model.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/data-service")
public class OrderController {

    private final OrderRepo orderRepo;

    public OrderController(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }
    @GetMapping("/orders")
    public Iterable<OrderDto> index() {

        final List<Order> orders = orderRepo.findAll();
        return orders.stream().map(order -> {
            OrderDto dto = new OrderDto();
            dto.setId(order.getId());
            dto.setName(order.getName());
            dto.setUser(order.getUser());
            return dto;
        }).collect(Collectors.toList());
    }
}
