package africa.semicolon.evoting.data.repositories;

import africa.semicolon.evoting.data.models.ElectionEntity;
import africa.semicolon.evoting.data.models.OfficeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficeRepository extends JpaRepository<OfficeEntity, Long> {
    List<OfficeEntity> findAllByElection(ElectionEntity election);
}
