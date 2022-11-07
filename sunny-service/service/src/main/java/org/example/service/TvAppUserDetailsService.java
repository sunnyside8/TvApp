package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.entity.UserEntity;
import org.example.model.user.TvAppUser;
import org.example.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@AllArgsConstructor
public class TvAppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(this::map)
                .orElseThrow(()-> new UsernameNotFoundException("User with username" + username + "was not found"));
    }

    private UserDetails map(UserEntity userEntity) {

        return new TvAppUser(
                userEntity.getId(),
                userEntity.getPassword(),
                userEntity.getUsername(),
                userEntity.getFullName(),
                userEntity.getEmail(),
                userEntity.
                        getRoles().
                        stream().
                        map(role -> new SimpleGrantedAuthority("ROLE_" + role)).collect(Collectors.toList()));
    }

}
