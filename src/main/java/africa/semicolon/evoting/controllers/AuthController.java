package africa.semicolon.evoting.controllers;

import africa.semicolon.evoting.data.dtos.requests.SignupRequestDto;
import africa.semicolon.evoting.data.dtos.responses.TokenResponseDto;
import africa.semicolon.evoting.services.AuthService;
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

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<TokenResponseDto> createAccount(@RequestBody SignupRequestDto request) {
        return new ResponseEntity<>(authService.signup(request), HttpStatus.OK);
    }
}
