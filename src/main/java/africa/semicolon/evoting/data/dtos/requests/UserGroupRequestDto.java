package africa.semicolon.evoting.data.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserGroupRequestDto {

    @NotBlank(message = "Group ID is required")
    private Long groupId;

    @NotBlank(message = "User ID is required")
    private Long userId;

}
