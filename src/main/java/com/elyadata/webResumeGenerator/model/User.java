package com.elyadata.webResumeGenerator.model;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private  String job;
    @Enumerated(EnumType.STRING)
    private Role type;
    @OneToMany
    private List<Resume> resumes;

}
