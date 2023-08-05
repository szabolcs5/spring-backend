package edu.bbte.orderspring.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.Check;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "items")
public class OrderItem extends BaseEntity {
    private String name;
    @Check(constraints = "price > 0")
    private Integer price;
    @Check(constraints = "quantity > 0")
    private Integer quantity;
    @Check(constraints = "total > 0")
    @Nullable
    private Integer total;
    private String imageSrc;
    private String description;
}
