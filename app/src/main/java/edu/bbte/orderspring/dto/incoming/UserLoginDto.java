package edu.bbte.orderspring.dto.incoming;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserLoginDto {
    @NotEmpty
    @Size(max=255)
    private String email;
    @NotEmpty
    @Size(max=255)
    private String password;
}
