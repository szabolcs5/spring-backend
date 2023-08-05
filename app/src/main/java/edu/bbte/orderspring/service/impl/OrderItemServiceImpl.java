package edu.bbte.orderspring.service.impl;

import edu.bbte.orderspring.model.OrderItem;
import edu.bbte.orderspring.repository.OrderItemRepository;
import edu.bbte.orderspring.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    OrderItemRepository orderItemRepository;


    @Override
    public Collection<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public Optional<OrderItem> findById(Long itemId) {
        return orderItemRepository.findById(itemId);
    }

    @Override
    public void deleteById(Long itemId) {
        orderItemRepository.deleteById(itemId);
    }

    @Override
    public OrderItem saveAndFlush(OrderItem orderItem) {
        return orderItemRepository.saveAndFlush(orderItem);
    }


}
