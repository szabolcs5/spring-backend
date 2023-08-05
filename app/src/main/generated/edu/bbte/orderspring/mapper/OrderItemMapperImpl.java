package edu.bbte.orderspring.mapper;

import edu.bbte.orderspring.dto.incoming.OrderItemCreationDto;
import edu.bbte.orderspring.dto.outgoing.OrderItemDetails;
import edu.bbte.orderspring.dto.outgoing.OrderItemReducedDto;
import edu.bbte.orderspring.model.OrderItem;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-05T21:44:49+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Amazon.com Inc.)"
)
@Component
public class OrderItemMapperImpl implements OrderItemMapper {

    @Override
    public OrderItemReducedDto modelToReducedDto(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        OrderItemReducedDto orderItemReducedDto = new OrderItemReducedDto();

        orderItemReducedDto.setId( orderItem.getId() );
        orderItemReducedDto.setName( orderItem.getName() );
        orderItemReducedDto.setPrice( orderItem.getPrice() );
        orderItemReducedDto.setQuantity( orderItem.getQuantity() );
        orderItemReducedDto.setTotal( orderItem.getTotal() );
        orderItemReducedDto.setImageSrc( orderItem.getImageSrc() );

        return orderItemReducedDto;
    }

    @Override
    public Collection<OrderItemReducedDto> modelsToReducedDtos(Collection<OrderItem> orderItems) {
        if ( orderItems == null ) {
            return null;
        }

        Collection<OrderItemReducedDto> collection = new ArrayList<OrderItemReducedDto>( orderItems.size() );
        for ( OrderItem orderItem : orderItems ) {
            collection.add( modelToReducedDto( orderItem ) );
        }

        return collection;
    }

    @Override
    public OrderItemDetails modelToDetails(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        OrderItemDetails orderItemDetails = new OrderItemDetails();

        orderItemDetails.setName( orderItem.getName() );
        orderItemDetails.setPrice( orderItem.getPrice() );
        orderItemDetails.setQuantity( orderItem.getQuantity() );
        orderItemDetails.setTotal( orderItem.getTotal() );
        orderItemDetails.setImageSrc( orderItem.getImageSrc() );
        orderItemDetails.setDescription( orderItem.getDescription() );

        return orderItemDetails;
    }

    @Override
    public OrderItem dtoToModel(OrderItemCreationDto orderItemCreationDto) {
        if ( orderItemCreationDto == null ) {
            return null;
        }

        OrderItem orderItem = new OrderItem();

        orderItem.setName( orderItemCreationDto.getName() );
        orderItem.setPrice( orderItemCreationDto.getPrice() );
        orderItem.setQuantity( orderItemCreationDto.getQuantity() );
        orderItem.setImageSrc( orderItemCreationDto.getImageSrc() );
        orderItem.setDescription( orderItemCreationDto.getDescription() );

        return orderItem;
    }
}
