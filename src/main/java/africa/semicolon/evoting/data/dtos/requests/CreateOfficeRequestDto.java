package africa.semicolon.evoting.data.dtos.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateOfficeRequestDto {

    private Long id;

    private String name;

    private Long electionId;

}
