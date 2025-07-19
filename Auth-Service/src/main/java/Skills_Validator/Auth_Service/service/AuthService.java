package Skills_Validator.Auth_Service.service;

import Skills_Validator.Auth_Service.dto.RegisterRequest;
import Skills_Validator.Auth_Service.dto.AuthRequest;
import Skills_Validator.Auth_Service.dto.AuthResponse;
import Skills_Validator.Auth_Service.model.User;
import Skills_Validator.Auth_Service.repository.UserRepository;
import Skills_Validator.Auth_Service.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent() ||
            userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Username or email already exists");
        }
        User user = new User(
                request.getUsername(),
                request.getEmail(),
                request.getPassword(), // store as plain text
                request.getRole() != null ? request.getRole() : "APPRENANT"
        );
        userRepository.save(user);
        String token = jwtUtil.generateToken(user.getUsername(), user.getRole());
        return new AuthResponse(token);
    }

    public AuthResponse authenticate(AuthRequest request) {
        Optional<User> userOpt = userRepository.findByUsername(request.getUsername());
        if (userOpt.isEmpty() || !request.getPassword().equals(userOpt.get().getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        User user = userOpt.get();
        String token = jwtUtil.generateToken(user.getUsername(), user.getRole());
        return new AuthResponse(token);
    }
} 