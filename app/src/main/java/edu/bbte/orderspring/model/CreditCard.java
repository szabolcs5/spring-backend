package edu.bbte.orderspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "credit_cards")
public class CreditCard extends BaseEntity {
    private String cardNumber;
    private String cardHolder;
    private String expirationDate;
    private String cvc;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
