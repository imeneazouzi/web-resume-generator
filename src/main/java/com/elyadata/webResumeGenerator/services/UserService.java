package com.elyadata.webResumeGenerator.services;

import com.elyadata.webResumeGenerator.dto.UserDTO;

import java.util.List;

public interface UserService {
      List<UserDTO> findAllUser();
     UserDTO addUser(UserDTO userDTO);
     UserDTO findUserById(Long id);
     List<UserDTO> findByEmail(String email);
}
