package edu.bbte.orderspring.dto.outgoing;

import lombok.Data;

@Data
public class OrderItemReducedDto {
    private Long id;
    private String name;
    private Integer price;
    private Integer quantity;
    private Integer total;
    private String imageSrc;
}
