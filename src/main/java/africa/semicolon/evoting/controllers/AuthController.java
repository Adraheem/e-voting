package africa.semicolon.evoting.controllers;

import africa.semicolon.evoting.data.dtos.requests.LoginRequestDto;
import africa.semicolon.evoting.data.dtos.requests.SignupRequestDto;
import africa.semicolon.evoting.data.dtos.responses.TokenResponseDto;
import africa.semicolon.evoting.services.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    @Operation(summary = "Create new account")
    public ResponseEntity<TokenResponseDto> createAccount(
            @RequestBody @Valid @Parameter(name = "request") SignupRequestDto request
    ) {
        return new ResponseEntity<>(authService.signup(request), HttpStatus.OK);
    }

    @PostMapping("/login")
    @Operation(summary = "Login")
    public ResponseEntity<TokenResponseDto> login(
            @RequestBody @Valid @Parameter(name = "request") LoginRequestDto request
    ) {
        return new ResponseEntity<>(authService.login(request), HttpStatus.OK);
    }
}
