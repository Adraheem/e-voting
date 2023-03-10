package africa.semicolon.evoting.data.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ElectionResultDto {

    private String office;

    private List<PostResultDto> posts;

    private Long totalVotes;

}
