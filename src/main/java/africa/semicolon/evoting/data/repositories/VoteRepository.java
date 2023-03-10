package africa.semicolon.evoting.data.repositories;

import africa.semicolon.evoting.data.models.PostEntity;
import africa.semicolon.evoting.data.models.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<VoteEntity, Long> {
    List<VoteEntity> findAllByPost(PostEntity post);

    Long countByPost(PostEntity post);
}
