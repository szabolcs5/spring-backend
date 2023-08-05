package edu.bbte.orderspring.service.impl;

import edu.bbte.orderspring.model.User;
import edu.bbte.orderspring.repository.UserRepository;
import edu.bbte.orderspring.service.UserService;
import edu.bbte.orderspring.utils.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Optional<User> login(User user) {
        Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            User userFromDb = userOptional.get();
            try {
                if (passwordEncoder.validatePassword(user.getPassword(), userFromDb.getPassword())) {
                    return Optional.of(userFromDb);
                }
            } catch (Exception e) {
                throw new RuntimeException("Error while validating password");
            }
        }
        return Optional.empty();
    }

    @Override
    public void register(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        } catch (Exception e) {
            throw new RuntimeException("Error while encoding password {}", e);
        }
        userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User saveAndFlush(User user) {
        return userRepository.saveAndFlush(user);
    }
}
