package africa.semicolon.evoting.data.dtos.requests;

import africa.semicolon.evoting.utils.RegexPattern;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignupRequestDto {

    @NotBlank(message = "FirstName cannot be null")
    private String firstName;

    private String lastName;

    @NotBlank(message = "Email address is required")
    @Pattern(regexp = RegexPattern.EMAIL, message = "Invalid email address")
    private String email;

    @Pattern(regexp = RegexPattern.PASSWORD, message = "Password is required")
    private String password;

}
