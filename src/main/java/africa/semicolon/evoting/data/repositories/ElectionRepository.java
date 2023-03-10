package africa.semicolon.evoting.data.repositories;

import africa.semicolon.evoting.data.models.ElectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectionRepository extends JpaRepository<ElectionEntity, Long> {
}
