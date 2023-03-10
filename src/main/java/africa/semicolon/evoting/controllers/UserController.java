package africa.semicolon.evoting.controllers;

import africa.semicolon.evoting.data.models.UserEntity;
import africa.semicolon.evoting.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("")
    @Operation(summary = "Get user details")
    public ResponseEntity<UserEntity> getUserDetails() {
        return new ResponseEntity<>(userService.getCurrentUser(), HttpStatus.OK);
    }

}
