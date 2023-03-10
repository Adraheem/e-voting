package africa.semicolon.evoting.data.dtos.responses;

import africa.semicolon.evoting.data.models.PostEntity;
import africa.semicolon.evoting.data.models.UserEntity;
import africa.semicolon.evoting.data.models.VoteEntity;
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

    public VoteDto(VoteEntity vote) {
        this.id = vote.getId();
        this.user = vote.getUser();
        this.post = vote.getPost();
        this.created_at = vote.getCreatedAt();
    }

    public static VoteDto map(VoteEntity vote){
        return new VoteDto(vote);
    }
}
