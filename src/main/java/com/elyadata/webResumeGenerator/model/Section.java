package com.elyadata.webResumeGenerator.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @OneToMany(mappedBy = "Section", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Parameters> parameters = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "id")
    private Resume resume;

    @OneToOne(mappedBy = "Section", cascade = CascadeType.ALL)
    private SectionType sectionType;

}