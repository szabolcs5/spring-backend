package edu.bbte.orderspring.mapper;

import edu.bbte.orderspring.dto.incoming.OrderItemCreationDto;
import edu.bbte.orderspring.dto.outgoing.OrderItemDetails;
import edu.bbte.orderspring.dto.outgoing.OrderItemReducedDto;
import edu.bbte.orderspring.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItemReducedDto modelToReducedDto(OrderItem orderItem);
    Collection<OrderItemReducedDto> modelsToReducedDtos(Collection<OrderItem> orderItems);
    OrderItemDetails modelToDetails(OrderItem orderItem);
    @Mapping(target = "id", ignore = true)
    OrderItem dtoToModel(OrderItemCreationDto orderItemCreationDto);

}
