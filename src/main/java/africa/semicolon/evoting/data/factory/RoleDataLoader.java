package africa.semicolon.evoting.data.factory;

import africa.semicolon.evoting.data.models.RoleEntity;
import africa.semicolon.evoting.data.repositories.RoleRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class RoleDataLoader {

    private RoleRepository roleRepository;

    @PostConstruct
    public void loadData() {
        List<RoleEntity> roles = List.of(
                RoleEntity.builder().id(1L).name("USER").build(),
                RoleEntity.builder().id(2L).name("ADMIN").build()
        );

        roleRepository.saveAll(roles);
    }
}
