package com.elyadata.webResumeGenerator.dto;
import com.elyadata.webResumeGenerator.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeDTO {
    private Long id;
    private  String title;
    private User user;
}
