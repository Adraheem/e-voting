package africa.semicolon.evoting.services;

import africa.semicolon.evoting.data.dtos.requests.CreateElectionRequestDto;
import africa.semicolon.evoting.data.dtos.responses.ElectionDto;
import africa.semicolon.evoting.data.models.ElectionEntity;

public interface ElectionService {
    ElectionDto createElection(CreateElectionRequestDto request);

    ElectionDto getElection(Long electionId);

    ElectionEntity getElectionEntity(Long electionId);

    ElectionDto updateElection(ElectionDto request);

    void deleteElection(Long electionId);

}
