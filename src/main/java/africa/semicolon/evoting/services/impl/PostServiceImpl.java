package africa.semicolon.evoting.services.impl;

import africa.semicolon.evoting.data.dtos.requests.CreatePostRequestDto;
import africa.semicolon.evoting.data.dtos.responses.PostDto;
import africa.semicolon.evoting.data.models.ElectionEntity;
import africa.semicolon.evoting.data.models.OfficeEntity;
import africa.semicolon.evoting.data.models.PostEntity;
import africa.semicolon.evoting.data.models.UserEntity;
import africa.semicolon.evoting.data.repositories.PostRepository;
import africa.semicolon.evoting.exceptions.specific.PostNotFoundException;
import africa.semicolon.evoting.exceptions.specific.UserNotFoundException;
import africa.semicolon.evoting.services.ElectionService;
import africa.semicolon.evoting.services.OfficeService;
import africa.semicolon.evoting.services.PostService;
import africa.semicolon.evoting.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private ElectionService electionService;
    private UserService userService;

    private OfficeService officeService;

    @Override
    public PostDto createPost(CreatePostRequestDto request) {
        UserEntity user = userService.findById(request.getUserId()).orElseThrow(UserNotFoundException::new);
        OfficeEntity office = officeService.getById(request.getOfficeId());

        PostEntity post = PostEntity.builder()
                .office(office)
                .user(user)
                .build();

        PostEntity savedPost = postRepository.save(post);

        return PostDto.map(savedPost);
    }

    @Override
    public PostDto updatePost(PostDto request) {
        PostEntity post = this.getPostEntity(request.getId());
        UserEntity user = userService.findById(request.getUser().getId()).orElseThrow(UserNotFoundException::new);
        OfficeEntity office = officeService.getById(request.getOffice().getId());

        post.setOffice(office);
        post.setUser(user);

        PostEntity savedPost = postRepository.save(post);

        return PostDto.map(savedPost);
    }

    @Override
    public PostDto getPost(Long id) {
        PostEntity post = this.getPostEntity(id);
        return PostDto.map(post);
    }

    @Override
    public PostEntity getPostEntity(Long id) {
        return postRepository.findById(id).orElseThrow(PostNotFoundException::new);
    }

    @Override
    public List<PostDto> getPostsByElectionId(Long electionId) {
        ElectionEntity election = electionService.getElectionEntity(electionId);
        return postRepository.findAllByOffice_Election_Id(election.getId())
                .stream()
                .map(PostDto::map)
                .collect(Collectors.toList());
    }

    @Override
    public void deletePost(Long id) {
        PostEntity post = this.getPostEntity(id);
        postRepository.delete(post);
    }
}
