package africa.semicolon.evoting.services;

import africa.semicolon.evoting.data.models.RoleEntity;

import java.util.Optional;

public interface RoleService {
    Optional<RoleEntity> getRole(String name);
}
