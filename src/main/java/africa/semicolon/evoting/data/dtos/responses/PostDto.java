package africa.semicolon.evoting.data.dtos.responses;

import africa.semicolon.evoting.data.models.ElectionEntity;
import africa.semicolon.evoting.data.models.UserEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostDto {

    private Long id;

    private String office;

    private ElectionEntity election;

    private UserEntity user;

}
