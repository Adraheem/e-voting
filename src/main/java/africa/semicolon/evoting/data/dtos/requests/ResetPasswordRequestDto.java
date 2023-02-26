package africa.semicolon.evoting.data.dtos.requests;

import lombok.Data;

@Data
public class ResetPasswordRequestDto {

    private String pin;

    private String newPassword;

    private String newPassword2;

}
