package edu.bbte.orderspring.service;

import edu.bbte.orderspring.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    Optional<User> login(User user);
    void register(User user);
    Optional<User> findById(Long id);

    User saveAndFlush(User user);
}
