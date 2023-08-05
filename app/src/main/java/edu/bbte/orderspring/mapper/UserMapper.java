package edu.bbte.orderspring.mapper;

import edu.bbte.orderspring.dto.incoming.UserLoginDto;
import edu.bbte.orderspring.dto.incoming.UserRegisterDto;
import edu.bbte.orderspring.dto.incoming.UserUpdateDto;
import edu.bbte.orderspring.dto.outgoing.UserProfileDto;
import edu.bbte.orderspring.dto.outgoing.UserReducedDto;
import edu.bbte.orderspring.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User registerDtoToUser(UserRegisterDto userLoginDto);

    UserReducedDto modelToReducedDto(User user);

    User loginDtoToUser(UserLoginDto userLoginDto);

    @Mapping(target = "id", ignore = true)
    User profileDtoToUser(UserUpdateDto userUpdateDto);

    UserProfileDto modelToProfileDto(User user);
}
