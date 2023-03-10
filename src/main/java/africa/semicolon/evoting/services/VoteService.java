package africa.semicolon.evoting.services;

import africa.semicolon.evoting.data.dtos.requests.CreateVoteRequestDto;
import africa.semicolon.evoting.data.dtos.responses.VoteDto;
import africa.semicolon.evoting.data.models.VoteEntity;

import java.util.List;

public interface VoteService {

    VoteDto vote(CreateVoteRequestDto request);

    List<VoteEntity> getVotesByPostId(Long id);

}
