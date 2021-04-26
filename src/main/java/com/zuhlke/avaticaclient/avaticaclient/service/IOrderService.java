package com.zuhlke.avaticaclient.avaticaclient.service;

import com.zuhlke.avaticaclient.avaticaclient.dto.OrderDto;
import com.zuhlke.avaticaclient.avaticaclient.model.Order;

public interface IOrderService {
    OrderDto updateOrder(Order order, Long id);
}
