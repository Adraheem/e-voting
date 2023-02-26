package africa.semicolon.evoting.security;

import africa.semicolon.evoting.data.models.RoleEntity;
import africa.semicolon.evoting.data.models.UserEntity;
import africa.semicolon.evoting.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity =
                userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username " +
                        "not found"));

        return AuthenticatedUser.
                builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities(mapRolesToAuthorities(userEntity.getRoles()))
                .build();
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(List<RoleEntity> roles) {
        return roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

//    @Bean
//    public UserEntity authenticatedUser(){
//        AuthenticatedUser user = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        return userRepository.findByUsername(user.getUsername()).orElse(null);
//    }
}
