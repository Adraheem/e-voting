package africa.semicolon.evoting.data.dtos.responses;

import africa.semicolon.evoting.data.models.ElectionEntity;
import africa.semicolon.evoting.data.models.OfficeEntity;
import africa.semicolon.evoting.data.models.PostEntity;
import africa.semicolon.evoting.data.models.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private Long id;

    private OfficeEntity office;

    private UserEntity user;

    public PostDto(PostEntity post) {
        this.id = post.getId();
        this.office = post.getOffice();
        this.user = post.getUser();
    }

    public static PostDto map(PostEntity post){
        return new PostDto(post);
    }
}
