package africa.semicolon.evoting.data.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateGroupRequestDto {

    @NotBlank
    private String name;

    private String description;
}
