package edu.bbte.orderspring.service;

import edu.bbte.orderspring.model.OrderItem;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public interface OrderItemService {
    Collection<OrderItem> getAllOrderItems();

    Optional<OrderItem> findById(Long itemId);

    void deleteById(Long itemId);

    OrderItem saveAndFlush(OrderItem orderItem);
}
