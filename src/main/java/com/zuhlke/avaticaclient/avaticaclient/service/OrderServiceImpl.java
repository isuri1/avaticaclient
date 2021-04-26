package com.zuhlke.avaticaclient.avaticaclient.service;

import com.zuhlke.avaticaclient.avaticaclient.dto.OrderDto;
import com.zuhlke.avaticaclient.avaticaclient.model.Order;
import com.zuhlke.avaticaclient.avaticaclient.model.User;
import com.zuhlke.avaticaclient.avaticaclient.repo.OrderRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService {

    private final OrderRepo orderRepo;
    private final UserServiceImpl userService;

    public OrderServiceImpl(OrderRepo orderRepo, UserServiceImpl userService) {
        this.orderRepo = orderRepo;
        this.userService = userService;
    }

    @Transactional
    @Override
    public OrderDto updateOrder(Order order, Long id) {

        final Optional<Order> existingOrder = orderRepo.findById(id);
        if (!existingOrder.isPresent()) {
            return null;
        } else {
            Order updatedOrder = existingOrder.get();
            updatedOrder.setId(order.getId());
            updatedOrder.setName(order.getName());
            orderRepo.save(updatedOrder);

            ModelMapper modelMapper = new ModelMapper();
            OrderDto orderDto = modelMapper.map(order, OrderDto.class);

            User user = new User();
            user.setId(1);
            user.setName("Isuri");
            userService.updateUser(user, user.getId());
            return orderDto;
        }
    }
}
