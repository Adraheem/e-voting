package africa.semicolon.evoting.services.impl;

import africa.semicolon.evoting.data.dtos.requests.CreateVoteRequestDto;
import africa.semicolon.evoting.data.dtos.responses.VoteDto;
import africa.semicolon.evoting.data.models.PostEntity;
import africa.semicolon.evoting.data.models.UserEntity;
import africa.semicolon.evoting.data.models.VoteEntity;
import africa.semicolon.evoting.data.repositories.VoteRepository;
import africa.semicolon.evoting.services.PostService;
import africa.semicolon.evoting.services.UserService;
import africa.semicolon.evoting.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {

    private VoteRepository voteRepository;
    private PostService postService;
    private UserService userService;

    @Autowired
    public VoteServiceImpl(VoteRepository voteRepository, PostService postService, UserService userService) {
        this.voteRepository = voteRepository;
        this.postService = postService;
        this.userService = userService;
    }

    @Override
    public VoteDto vote(CreateVoteRequestDto request) {
        UserEntity user = userService.getCurrentUser();
        PostEntity post = postService.getPostEntity(request.getPostId());

        VoteEntity vote = VoteEntity.builder()
                .user(user)
                .post(post)
                .build();

        VoteEntity savedVote = voteRepository.save(vote);
        return VoteDto.map(savedVote);
    }

    @Override
    public List<VoteEntity> getVotesByPostId(Long id) {
        PostEntity post = postService.getPostEntity(id);
        return voteRepository.findAllByPost(post);
    }

    @Override
    public Long getVoteCountByPostId(Long id) {
        PostEntity post = postService.getPostEntity(id);
        return voteRepository.countByPost(post);
    }
}
