package edu.bbte.orderspring.controller;

import edu.bbte.orderspring.controller.exception.BadRequestException;
import edu.bbte.orderspring.dto.incoming.UserUpdateDto;
import edu.bbte.orderspring.dto.outgoing.UserProfileDto;
import edu.bbte.orderspring.mapper.UserMapper;
import edu.bbte.orderspring.model.User;
import edu.bbte.orderspring.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PatchMapping(path="/{id}")
    public UserProfileDto register(@RequestBody @Valid UserUpdateDto userUpdateDto, @PathVariable Long id) {
        User newUser = userMapper.profileDtoToUser(userUpdateDto);
        User user = userService.findById(id).orElseThrow(BadRequestException::new);
        user.setUsername(newUser.getUsername());
        user.setImageUrl(newUser.getImageUrl());
        userService.saveAndFlush(user);
        return userMapper.modelToProfileDto(user);
    }

    @GetMapping(path="/{id}")
    public UserProfileDto getUser(@PathVariable Long id) {
        User user = userService.findById(id).orElseThrow(BadRequestException::new);
        return userMapper.modelToProfileDto(user);
    }
}
