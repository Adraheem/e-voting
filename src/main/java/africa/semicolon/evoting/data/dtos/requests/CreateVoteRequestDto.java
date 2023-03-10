package africa.semicolon.evoting.data.dtos.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateVoteRequestDto {

    @NotNull(message = "Choose a candidate to vote for")
    private Long postId;

}
