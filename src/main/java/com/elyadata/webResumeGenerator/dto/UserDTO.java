package com.elyadata.webResumeGenerator.dto;

import com.elyadata.webResumeGenerator.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private  String job;
    private Role type;
}
