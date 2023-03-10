package africa.semicolon.evoting.data.repositories;

import africa.semicolon.evoting.data.models.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
