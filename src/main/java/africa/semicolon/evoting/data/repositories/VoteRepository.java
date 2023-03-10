package africa.semicolon.evoting.data.repositories;

import africa.semicolon.evoting.data.models.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<VoteEntity, Long> {
}
