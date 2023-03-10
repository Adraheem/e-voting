package africa.semicolon.evoting.services;

import africa.semicolon.evoting.data.dtos.requests.CreatePostRequestDto;
import africa.semicolon.evoting.data.dtos.responses.PostDto;
import africa.semicolon.evoting.data.models.PostEntity;

import java.util.List;

public interface PostService {

    PostDto createPost(CreatePostRequestDto request);

    PostDto updatePost(PostDto request);

    PostDto getPost(Long id);

    PostEntity getPostEntity(Long id);

    List<PostDto> getPostsByElectionId(Long electionId);

    void deletePost(Long id);

}
