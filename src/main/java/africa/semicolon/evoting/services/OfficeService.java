package africa.semicolon.evoting.services;

import africa.semicolon.evoting.data.dtos.requests.CreateOfficeRequestDto;
import africa.semicolon.evoting.data.models.OfficeEntity;

import java.util.List;

public interface OfficeService {

    OfficeEntity createOffice(CreateOfficeRequestDto request);

    OfficeEntity save(OfficeEntity entity);

    OfficeEntity getById(Long id);

    void deleteById(Long id);

    List<OfficeEntity> findAllByElectionId(Long id);

}
