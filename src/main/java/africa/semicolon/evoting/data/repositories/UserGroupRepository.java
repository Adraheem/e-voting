package africa.semicolon.evoting.data.repositories;

import africa.semicolon.evoting.data.models.GroupEntity;
import africa.semicolon.evoting.data.models.UserEntity;
import africa.semicolon.evoting.data.models.UserGroupEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroupEntity, Long> {

    Boolean existsByUserAndGroup(UserEntity user, GroupEntity group);

    void deleteAllByUser(UserEntity user);

    List<UserGroupEntity> findAllByGroup(GroupEntity group);

    Page<UserGroupEntity> findAllByUser(UserEntity user, Pageable pageable);

}
