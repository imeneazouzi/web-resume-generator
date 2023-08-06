package com.elyadata.webResumeGenerator.services.impl;


import com.elyadata.webResumeGenerator.dto.ResumeDTO;
import com.elyadata.webResumeGenerator.dto.UserDTO;
import com.elyadata.webResumeGenerator.execption.NotFoundException;
import com.elyadata.webResumeGenerator.mapper.UserMapper;
import com.elyadata.webResumeGenerator.repo.UserRepository;
import com.elyadata.webResumeGenerator.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    @Override
    public List<UserDTO> findAllUser() {
        return userMapper.toDto(userRepository.findAll());
    }
    @Override
    public UserDTO addUser(UserDTO userDTO) {
        return userMapper.toDto(userRepository.save(userMapper.toEntity(userDTO)));
    }

    @Override
    public UserDTO findUserById(Long id) {
        return userMapper.toDto(userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("userDto with id " + id + " was not found")));
    }

    @Override
    public List<UserDTO> findByEmail(String email) {
        return userMapper.toDto(userRepository.findByEmail(email));
    }
}
