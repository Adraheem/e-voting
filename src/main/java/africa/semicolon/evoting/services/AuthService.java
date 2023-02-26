package africa.semicolon.evoting.services;

import africa.semicolon.evoting.data.dtos.requests.ChangePasswordRequestDto;
import africa.semicolon.evoting.data.dtos.requests.LoginRequestDto;
import africa.semicolon.evoting.data.dtos.requests.ResetPasswordRequestDto;
import africa.semicolon.evoting.data.dtos.requests.SignupRequestDto;
import africa.semicolon.evoting.data.dtos.responses.TokenResponseDto;

public interface AuthService {

    TokenResponseDto signup(SignupRequestDto request);

    TokenResponseDto login(LoginRequestDto request);

    void resetPassword(ResetPasswordRequestDto request);

    void changePassword(ChangePasswordRequestDto request);

    void deleteAll();

}
