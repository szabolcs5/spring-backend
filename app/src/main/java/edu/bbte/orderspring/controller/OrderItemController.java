package edu.bbte.orderspring.controller;

import edu.bbte.orderspring.controller.exception.NotFoundException;
import edu.bbte.orderspring.dto.incoming.OrderItemCreationDto;
import edu.bbte.orderspring.dto.outgoing.OrderItemDetails;
import edu.bbte.orderspring.dto.outgoing.OrderItemReducedDto;
import edu.bbte.orderspring.mapper.OrderItemMapper;
import edu.bbte.orderspring.model.OrderItem;
import edu.bbte.orderspring.service.OrderItemService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/items")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @GetMapping
    public Collection<OrderItemReducedDto> getAllOrderItems() {
        return orderItemMapper.modelsToReducedDtos(orderItemService.getAllOrderItems());
    }

    @GetMapping("/{itemId}")
    public OrderItemDetails findItemById(@PathVariable("itemId") Long itemId) {
        OrderItem orderItem = orderItemService.findById(itemId).orElseThrow(NotFoundException::new);
        return orderItemMapper.modelToDetails(orderItem);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderItemDetails saveItem(@RequestBody @Valid OrderItemCreationDto orderItemDetails) {
        OrderItem orderItem = orderItemMapper.dtoToModel(orderItemDetails);
        return orderItemMapper.modelToDetails(orderItemService.saveAndFlush(orderItem));
    }

    @DeleteMapping("/{itemId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItemById(@PathVariable("itemId") Long itemId) {
        orderItemService.deleteById(itemId);
    }
}
