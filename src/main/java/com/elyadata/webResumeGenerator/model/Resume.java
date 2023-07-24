package com.elyadata.webResumeGenerator.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String title;
    @OneToMany
    private List<Section> sections;

}

