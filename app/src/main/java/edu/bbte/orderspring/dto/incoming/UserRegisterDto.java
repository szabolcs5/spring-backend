package edu.bbte.orderspring.dto.incoming;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegisterDto {
    @NotEmpty
    @Size(max=255)
    private String username;
    @NotEmpty
    @Size(max=255)
    private String password;
    @NotEmpty
    @Size(max=255)
    @Email
    private String email;
}
