package africa.semicolon.evoting.services.impl;

import africa.semicolon.evoting.data.models.RoleEntity;
import africa.semicolon.evoting.data.repositories.RoleRepository;
import africa.semicolon.evoting.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Override
    public Optional<RoleEntity> getRole(String name) {
        return roleRepository.findByName(name);
    }
}
