package edu.bbte.orderspring.dto.outgoing;

import lombok.Data;

@Data
public class OrderItemDetails {
        private String name;
        private Integer price;
        private Integer quantity;
        private Integer total;
        private String imageSrc;
        private String description;
}
