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


    @OneToMany(mappedBy = "Resume", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Section> sections = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

}

