package africa.semicolon.evoting.data.dtos.requests;

import africa.semicolon.evoting.utils.RegexPattern;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequestDto {

    @NotBlank(message = "email is required")
    @Pattern(regexp = RegexPattern.EMAIL, message = "Invalid email address")
    private String email;

    @NotBlank(message = "password is required")
    private String password;

}
