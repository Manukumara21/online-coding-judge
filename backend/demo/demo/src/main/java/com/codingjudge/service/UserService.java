package com.codingjudge.service;

import com.codingjudge.dto.AuthResponse;
import com.codingjudge.dto.RegisterRequest;
import com.codingjudge.dto.UserDto;
import com.codingjudge.entity.User;
import com.codingjudge.exception.BadRequestException;
import com.codingjudge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.codingjudge.security.JwtUtil;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public AuthResponse login(String email, String password) {

    User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new BadRequestException("Invalid email or password"));

    if (!passwordEncoder.matches(password, user.getPassword())) {
        throw new BadRequestException("Invalid email or password");
    }

    String token = jwtUtil.generateToken(
        user.getEmail(),
        user.getRole()
    );

    UserDto userDto = convertToUserDto(user);

    return new AuthResponse(
            true,
            "Login successful",
            token,
            userDto
    );
}


    public AuthResponse register(RegisterRequest request) {
        // Check if passwords match
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            throw new BadRequestException("Passwords do not match");
        }

        // Check if username already exists
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new BadRequestException("Username already exists");
        }

        // Check if email already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new BadRequestException("Email already exists");
        }

        // Create new user
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("USER");

        // Save to database
        User savedUser = userRepository.save(user);

        // Create response
        UserDto userDto = convertToUserDto(savedUser);
        return new AuthResponse(true, "User registered successfully", userDto);
    }

    public UserDto getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(this::convertToUserDto).orElse(null);
    }

    public UserDto getUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(this::convertToUserDto).orElse(null);
    }

    public boolean userExists(String username) {
        return userRepository.existsByUsername(username);
    }

    private UserDto convertToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
