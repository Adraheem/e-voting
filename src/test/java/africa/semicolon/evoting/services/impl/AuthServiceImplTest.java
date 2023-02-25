package africa.semicolon.evoting.services.impl;

import africa.semicolon.evoting.data.dtos.requests.LoginRequestDto;
import africa.semicolon.evoting.data.dtos.requests.SignupRequestDto;
import africa.semicolon.evoting.data.dtos.responses.TokenResponseDto;
import africa.semicolon.evoting.services.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@Slf4j
class AuthServiceImplTest {

    @Autowired
    private AuthService authService;

    @BeforeEach
    void setUp() {
        authService.deleteAll();
    }

    @AfterEach
    void tearDown() {
        authService.deleteAll();
    }

    @Test
    void userCanRegisterTest() {
        SignupRequestDto request = SignupRequestDto.builder()
                .firstName("John")
                .lastName("Doe")
                .email("johndoe@gmail.com")
                .password("JohnDoe555!")
                .build();

        TokenResponseDto token = authService.signup(request);
        log.info(token.toString());
        assertNotNull(token);
    }

    @Test
    void userCanLoginTest() {
        SignupRequestDto signupRequest = SignupRequestDto.builder()
                .firstName("John")
                .lastName("Doe")
                .email("johndoe@gmail.com")
                .password("JohnDoe555!")
                .build();

        authService.signup(signupRequest);

        LoginRequestDto request = LoginRequestDto.builder()
                .emailAddress("johndoe@gmail.com")
                .password("JohnDoe555!")
                .build();

        TokenResponseDto token = authService.login(request);
        assertNotNull(token);
    }
}