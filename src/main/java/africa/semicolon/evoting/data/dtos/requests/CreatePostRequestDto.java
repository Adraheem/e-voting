package africa.semicolon.evoting.data.dtos.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePostRequestDto {

    private Long id;

    private String office;

    private Long electionId;

    private Long userId;

}
