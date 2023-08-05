package edu.bbte.orderspring.controller;

import edu.bbte.orderspring.controller.exception.BadRequestException;
import edu.bbte.orderspring.dto.incoming.UserLoginDto;
import edu.bbte.orderspring.dto.incoming.UserRegisterDto;
import edu.bbte.orderspring.dto.outgoing.UserReducedDto;
import edu.bbte.orderspring.mapper.UserMapper;
import edu.bbte.orderspring.model.User;
import edu.bbte.orderspring.service.UserService;
import edu.bbte.orderspring.utils.TokenGenerator;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/api")
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TokenGenerator tokenGenerator;

    @PostMapping(path="/login")
    public UserReducedDto login(@RequestBody @Valid UserLoginDto userLoginDto) {
        User user = userMapper.loginDtoToUser(userLoginDto);
        User userFromDb = userService.login(user).orElseThrow(BadRequestException::new);
        UserReducedDto userReducedDto = userMapper.modelToReducedDto(userFromDb);
        userReducedDto.setToken(tokenGenerator.generateToken());
        return userReducedDto;
    }

    @PostMapping(path="/register")
    public UserReducedDto register(@RequestBody @Valid UserRegisterDto userRegisterDto) {
        User user = userMapper.registerDtoToUser(userRegisterDto);
        userService.register(user);
        return userMapper.modelToReducedDto(user);
    }
}
