package africa.semicolon.evoting.services.impl;

import africa.semicolon.evoting.data.dtos.requests.CreatePostRequestDto;
import africa.semicolon.evoting.data.dtos.responses.PostDto;
import africa.semicolon.evoting.data.models.ElectionEntity;
import africa.semicolon.evoting.data.models.PostEntity;
import africa.semicolon.evoting.data.models.UserEntity;
import africa.semicolon.evoting.data.repositories.PostRepository;
import africa.semicolon.evoting.exceptions.specific.PostNotFoundException;
import africa.semicolon.evoting.exceptions.specific.UserNotFoundException;
import africa.semicolon.evoting.services.ElectionService;
import africa.semicolon.evoting.services.PostService;
import africa.semicolon.evoting.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private ElectionService electionService;
    private UserService userService;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, ElectionService electionService, UserService userService) {
        this.postRepository = postRepository;
        this.electionService = electionService;
        this.userService = userService;
    }

    @Override
    public PostDto createPost(CreatePostRequestDto request) {
        ElectionEntity election = electionService.getElectionEntity(request.getElectionId());
        UserEntity user = userService.findById(request.getUserId()).orElseThrow(UserNotFoundException::new);

        PostEntity post = PostEntity.builder()
                .office(request.getOffice())
                .user(user)
                .election(election)
                .build();

        PostEntity savedPost = postRepository.save(post);

        return PostDto.map(savedPost);
    }

    @Override
    public PostDto updatePost(PostDto request) {
        PostEntity post = this.getPostEntity(request.getId());
        ElectionEntity election = electionService.getElectionEntity(request.getElection().getId());
        UserEntity user = userService.findById(request.getUser().getId()).orElseThrow(UserNotFoundException::new);

        post.setOffice(request.getOffice());
        post.setUser(user);
        post.setElection(election);

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
    public List<PostEntity> getPostsByElectionId(Long electionId) {
        ElectionEntity election = electionService.getElectionEntity(electionId);
        return postRepository.findAllByElection_Id(election.getId());
    }

    @Override
    public void deletePost(Long id) {
        PostEntity post = this.getPostEntity(id);
        postRepository.delete(post);
    }
}
