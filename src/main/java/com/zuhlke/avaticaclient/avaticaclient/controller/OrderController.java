package com.zuhlke.avaticaclient.avaticaclient.controller;

import com.zuhlke.avaticaclient.avaticaclient.repo.OrderRepo;
import com.zuhlke.avaticaclient.avaticaclient.dto.OrderDto;
import com.zuhlke.avaticaclient.avaticaclient.model.Order;
import com.zuhlke.avaticaclient.avaticaclient.service.IOrderService;
import com.zuhlke.avaticaclient.avaticaclient.service.OrderServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/data-service")
public class OrderController {

    private final OrderRepo orderRepo;
    private final IOrderService orderService;

    public OrderController(OrderRepo orderRepo, IOrderService orderService) {
        this.orderRepo = orderRepo;
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public Iterable<OrderDto> index() {

        final List<Order> orders = orderRepo.findAll();
        return orders.stream().map(order -> {
            ModelMapper modelMapper = new ModelMapper();
            OrderDto orderDto = modelMapper.map(order, OrderDto.class);
            return orderDto;
        }).collect(Collectors.toList());
    }

    @PutMapping("/orders/{id}")
    public OrderDto updateOrder(@RequestBody Order order, @PathVariable Long id) {

        final OrderDto orderDto = orderService.updateOrder(order, id);
        return orderDto;
    }
}
