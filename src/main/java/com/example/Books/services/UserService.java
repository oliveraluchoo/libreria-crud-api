package com.example.Books.services;

import com.example.Books.entities.User;
import com.example.Books.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No user with id: " + id));
    }

    public User getUserByUsername(String username){
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No user with username: " + username));
    }
    public User saveUser(User givenUser){
        User user = new User();
        user.setUsername(givenUser.getUsername());
        user.setPassword(passwordEncoder.encode(givenUser.getPassword()));
        user.setRole("ROLE_" + givenUser.getRole());
        return userRepository.save(user);
    }

}
