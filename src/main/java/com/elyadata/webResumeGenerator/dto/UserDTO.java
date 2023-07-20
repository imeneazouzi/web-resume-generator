package com.elyadata.webResumeGenerator.dto;

import com.elyadata.webResumeGenerator.model.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class UserDTO {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private  String job;
    private Role type;
}
