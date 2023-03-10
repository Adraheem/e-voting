package africa.semicolon.evoting.services.impl;

import africa.semicolon.evoting.data.dtos.requests.CreateElectionRequestDto;
import africa.semicolon.evoting.data.dtos.responses.ElectionDto;
import africa.semicolon.evoting.data.models.ElectionEntity;
import africa.semicolon.evoting.data.models.GroupEntity;
import africa.semicolon.evoting.data.repositories.ElectionRepository;
import africa.semicolon.evoting.exceptions.specific.ElectionNotFoundException;
import africa.semicolon.evoting.exceptions.specific.GroupNotFoundException;
import africa.semicolon.evoting.services.ElectionService;
import africa.semicolon.evoting.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectionServiceImpl implements ElectionService {

    private ElectionRepository electionRepository;
    private GroupService groupService;

    @Autowired
    public ElectionServiceImpl(ElectionRepository electionRepository, GroupService groupService) {
        this.electionRepository = electionRepository;
        this.groupService = groupService;
    }

    @Override
    public ElectionDto createElection(CreateElectionRequestDto request) {
        GroupEntity group = groupService.findById(request.getGroupId()).orElseThrow(GroupNotFoundException::new);

        ElectionEntity election = ElectionEntity.builder()
                .name(request.getName())
                .description(request.getDescription())
                .startAt(request.getStartAt())
                .endAt(request.getEndAt())
                .group(group)
                .build();

        ElectionEntity savedElection = electionRepository.save(election);

        return ElectionDto.map(savedElection);
    }

    @Override
    public ElectionDto getElection(Long electionId) {
        return ElectionDto.map(this.getElectionEntity(electionId));
    }

    @Override
    public ElectionEntity getElectionEntity(Long electionId) {
        return electionRepository.findById(electionId).orElseThrow(ElectionNotFoundException::new);
    }

    @Override
    public ElectionDto updateElection(ElectionDto request) {
        ElectionEntity election = this.getElectionEntity(request.getId());
        GroupEntity group = groupService.findById(request.getGroup().getId()).orElseThrow(GroupNotFoundException::new);

        election.setName(request.getName());
        election.setDescription(request.getDescription());
        election.setStartAt(request.getStartAt());
        election.setEndAt(request.getEndAt());
        election.setGroup(group);

        ElectionEntity savedElection = electionRepository.save(election);

        return ElectionDto.map(savedElection);
    }

    @Override
    public void deleteElection(Long electionId) {
        ElectionEntity election = this.getElectionEntity(electionId);
        electionRepository.delete(election);
    }
}
