package edu.bbte.orderspring.mapper;

import edu.bbte.orderspring.dto.incoming.UserLoginDto;
import edu.bbte.orderspring.dto.incoming.UserRegisterDto;
import edu.bbte.orderspring.dto.incoming.UserUpdateDto;
import edu.bbte.orderspring.dto.outgoing.UserProfileDto;
import edu.bbte.orderspring.dto.outgoing.UserReducedDto;
import edu.bbte.orderspring.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-05T21:44:48+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User registerDtoToUser(UserRegisterDto userLoginDto) {
        if ( userLoginDto == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( userLoginDto.getUsername() );
        user.setPassword( userLoginDto.getPassword() );
        user.setEmail( userLoginDto.getEmail() );

        return user;
    }

    @Override
    public UserReducedDto modelToReducedDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserReducedDto userReducedDto = new UserReducedDto();

        userReducedDto.setId( user.getId() );
        userReducedDto.setUsername( user.getUsername() );
        userReducedDto.setEmail( user.getEmail() );
        userReducedDto.setImageUrl( user.getImageUrl() );

        return userReducedDto;
    }

    @Override
    public User loginDtoToUser(UserLoginDto userLoginDto) {
        if ( userLoginDto == null ) {
            return null;
        }

        User user = new User();

        user.setPassword( userLoginDto.getPassword() );
        user.setEmail( userLoginDto.getEmail() );

        return user;
    }

    @Override
    public User profileDtoToUser(UserUpdateDto userUpdateDto) {
        if ( userUpdateDto == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( userUpdateDto.getUsername() );
        user.setImageUrl( userUpdateDto.getImageUrl() );

        return user;
    }

    @Override
    public UserProfileDto modelToProfileDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserProfileDto userProfileDto = new UserProfileDto();

        userProfileDto.setImageUrl( user.getImageUrl() );
        userProfileDto.setUsername( user.getUsername() );

        return userProfileDto;
    }
}
