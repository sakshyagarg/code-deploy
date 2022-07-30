package com.project.mama.earth.service;

import com.project.mama.earth.dto.CartDto;
import com.project.mama.earth.model.Order;
import com.project.mama.earth.model.OrderedItems;
import com.project.mama.earth.repository.OrderRepository;
import com.project.mama.earth.repository.OrderedItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderedItemsRepository orderedItemsRepository;

    public void createOrder(List<CartDto> cartItems) {
        Order order = new Order();
        long price = 0;
        for(CartDto cartItem : cartItems ) {
            price+=cartItem.getPrice()*cartItem.getQuantity();
        }
        order.setTotalPrice(price);
        order.setCreatedDate(new Date());
        order = orderRepository.save(order);
        long orderId = order.getId();
        orderRepository.flush();
        for(CartDto cartItem : cartItems ) {
            OrderedItems orderedItem = new OrderedItems(cartItem);
            orderedItem.setOrderId(orderId);
            orderedItemsRepository.save(orderedItem);
        }
    }

    public List<OrderedItems> getAllOrders(String username) {
        return orderedItemsRepository.findAll()
                .stream().filter(order-> order.getUsername().equals(username)).collect(Collectors.toList());
    }

}
