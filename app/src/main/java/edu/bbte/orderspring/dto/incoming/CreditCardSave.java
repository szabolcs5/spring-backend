package edu.bbte.orderspring.dto.incoming;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreditCardSave {
    @NotEmpty
    private String cardHolder;

    @NotEmpty
    @Size(max=16)
    private String cardNumber;

    @NotEmpty
    @Size(max=3)
    private String cvc;

    @NotEmpty
    @Size(max=5)
    private String expirationDate;

    @NotEmpty
    private String userId;
}
