package edu.bbte.orderspring.dto.outgoing;

import lombok.Data;

@Data
public class UserReducedDto {
    private Long id;
    private String username;
    private String email;
    private String imageUrl;
    private String token;
}
