package africa.semicolon.evoting.data.dtos.responses;

import africa.semicolon.evoting.data.models.ElectionEntity;
import africa.semicolon.evoting.data.models.PostEntity;
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

    public PostDto(PostEntity post) {
        this.id = post.getId();
        this.office = post.getOffice();
        this.election = post.getElection();
        this.user = post.getUser();
    }

    public static PostDto map(PostEntity post){
        return new PostDto(post);
    }
}
