
package Skills_Validator.Auth_Service.service;
import Skills_Validator.Auth_Service.dto.AuthRequest;
import Skills_Validator.Auth_Service.dto.AuthResponse;
import Skills_Validator.Auth_Service.model.User;
import Skills_Validator.Auth_Service.repository.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        // Nettoyer la base avant chaque test
        userRepository.deleteAll();
        // Ajouter un utilisateur de test
        User user = new User("testuser", "test@mail.com", "password", "APPRENANT");
        userRepository.save(user);
    }

    @Test
    void testAuthenticateSuccess() {
        AuthRequest request = new AuthRequest();
        request.setUsername("testuser");
        request.setPassword("password");
        AuthResponse response = authService.authenticate(request);
        assertNotNull(response.getToken());
    }

    @Test
    void testAuthenticateFail() {
        AuthRequest request = new AuthRequest();
        request.setUsername("testuser");
        request.setPassword("wrongpassword");
        assertThrows(RuntimeException.class, () -> authService.authenticate(request));
    }
}