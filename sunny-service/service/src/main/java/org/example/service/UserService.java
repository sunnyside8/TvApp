package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.binding.UserRegisterBindingModel;
import org.example.model.entity.UserEntity;
import org.example.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserEntity registerUser(UserRegisterBindingModel userRegisterBindingModel) {
        return new UserEntity();
    }
}
