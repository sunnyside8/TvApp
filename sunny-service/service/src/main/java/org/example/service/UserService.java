package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.binding.UserRegisterBindingModel;
import org.example.model.entity.UserEntity;
import org.example.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserEntity registerUser(UserRegisterBindingModel userRegisterBindingModel) {
        UserEntity userEntity = modelMapper.map(userRegisterBindingModel, UserEntity.class);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setRoles(Set.of("USER"));

        return userRepository.save(userEntity);

    }
}
