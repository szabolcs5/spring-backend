package edu.bbte.orderspring.dto.incoming;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class OrderItemCreationDto {
    @NotEmpty
    private String name;
    @PositiveOrZero
    private Integer price;
    @PositiveOrZero
    private Integer quantity;
    @NotEmpty
    private String imageSrc;
    @NotEmpty
    private String description;
}
