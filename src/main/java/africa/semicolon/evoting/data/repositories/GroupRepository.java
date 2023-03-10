package africa.semicolon.evoting.data.repositories;

import africa.semicolon.evoting.data.models.GroupEntity;
import africa.semicolon.evoting.data.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, Long> {
}
