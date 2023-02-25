package africa.semicolon.evoting.services;

import africa.semicolon.evoting.data.dtos.requests.LoginRequestDto;
import africa.semicolon.evoting.data.dtos.requests.SignupRequestDto;
import africa.semicolon.evoting.data.dtos.responses.TokenResponseDto;

public interface AuthService {

    TokenResponseDto signup(SignupRequestDto request);

    TokenResponseDto login(LoginRequestDto request);

    void deleteAll();

}
