package africa.semicolon.evoting.services.impl;

import africa.semicolon.evoting.data.dtos.requests.CreateOfficeRequestDto;
import africa.semicolon.evoting.data.models.ElectionEntity;
import africa.semicolon.evoting.data.models.OfficeEntity;
import africa.semicolon.evoting.data.repositories.OfficeRepository;
import africa.semicolon.evoting.exceptions.specific.OfficeNotFoundException;
import africa.semicolon.evoting.services.ElectionService;
import africa.semicolon.evoting.services.OfficeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OfficeServiceImpl implements OfficeService {

    private final OfficeRepository officeRepository;
    private final ElectionService electionService;

    @Override
    public OfficeEntity createOffice(CreateOfficeRequestDto request) {
        ElectionEntity election = electionService.getElectionEntity(request.getElectionId());

        return officeRepository.save(OfficeEntity.builder()
                .name(request.getName())
                .election(election)
                .build());
    }

    @Override
    public OfficeEntity save(OfficeEntity entity) {
        return officeRepository.save(entity);
    }

    @Override
    public OfficeEntity getById(Long id) {
        return officeRepository.findById(id).orElseThrow(OfficeNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        OfficeEntity office = this.getById(id);
        officeRepository.delete(office);
    }

    @Override
    public List<OfficeEntity> findAllByElectionId(Long id) {
        ElectionEntity election = electionService.getElectionEntity(id);
        return officeRepository.findAllByElection(election);
    }
}
