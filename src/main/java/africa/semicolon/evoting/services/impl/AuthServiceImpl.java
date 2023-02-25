package africa.semicolon.evoting.services.impl;

import africa.semicolon.evoting.data.dtos.requests.LoginRequestDto;
import africa.semicolon.evoting.data.dtos.requests.SignupRequestDto;
import africa.semicolon.evoting.data.dtos.responses.TokenResponseDto;
import africa.semicolon.evoting.data.models.RoleEntity;
import africa.semicolon.evoting.data.models.UserEntity;
import africa.semicolon.evoting.data.repositories.UserRepository;
import africa.semicolon.evoting.exceptions.specific.EmailAlreadyUsedException;
import africa.semicolon.evoting.exceptions.specific.InternalServerErrorException;
import africa.semicolon.evoting.exceptions.specific.InvalidLoginDetailsException;
import africa.semicolon.evoting.security.JwtGenerator;
import africa.semicolon.evoting.services.AuthService;
import africa.semicolon.evoting.services.RoleService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@Primary
@AllArgsConstructor
@Slf4j
@Transactional
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtGenerator jwtGenerator;
    private AuthenticationManager authenticationManager;
    private RoleService roleService;

    @Override
    public TokenResponseDto signup(@Valid SignupRequestDto request) {
        if (userRepository.existsByUsername(request.getEmail())) {
            throw new EmailAlreadyUsedException();
        }

        RoleEntity userRole = roleService.getRole("USER").orElseThrow(InternalServerErrorException::new);

        UserEntity newUser = UserEntity.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .username(request.getEmail())
                .emailAddress(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(Collections.singletonList(userRole))
                .build();

        userRepository.save(newUser);

        String token = jwtGenerator.generateToken(newUser);

        return TokenResponseDto.builder()
                .token(token)
                .build();
    }

    @Override
    public TokenResponseDto login(@Valid LoginRequestDto request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmailAddress(),
                            request.getPassword())
            );
            String token = jwtGenerator.generateToken(authentication);
            return TokenResponseDto.builder().token(token).build();
        } catch (Exception e) {
            throw new InvalidLoginDetailsException();
        }
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }
}
