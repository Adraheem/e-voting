package africa.semicolon.evoting.data.repositories;

import africa.semicolon.evoting.data.models.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findAllByElection_Id(Long election_id);
}
