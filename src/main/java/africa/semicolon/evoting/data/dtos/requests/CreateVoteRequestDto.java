package africa.semicolon.evoting.data.dtos.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateVoteRequestDto {

    @NotNull(message = "Choose a candidate to vote for")
    private Long postId;

}
