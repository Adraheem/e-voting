package africa.semicolon.evoting.data.dtos.responses;

import africa.semicolon.evoting.data.models.PostEntity;
import africa.semicolon.evoting.data.models.UserEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class VoteDto {

    private Long id;

    private UserEntity user;

    private PostEntity post;

    private LocalDateTime created_at;

}
