package edu.bbte.orderspring.dto.incoming;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserUpdateDto {
    @NotEmpty
    private String imageUrl;
    @NotEmpty
    private String username;
}
