package africa.semicolon.evoting.data.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
@Builder
public class GroupRequestDto {

    @NotNull(message = "id is required")
    private Long id;

    @NotBlank(message = "Group name is required")
    private String name;

    private String description;

    private Optional<LocalDateTime> created_at = Optional.empty();

}
