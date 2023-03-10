package africa.semicolon.evoting.data.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CreateElectionRequestDto {

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    @NotNull(message = "Set when election starts")
    private LocalDateTime startAt;

    @NotNull(message = "Set when election ends")
    private LocalDateTime endAt;

    @NotNull(message = "Choose group for election")
    private Long groupId;

}
