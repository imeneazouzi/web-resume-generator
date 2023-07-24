package com.elyadata.webResumeGenerator.model;
import jakarta.persistence.*;
import lombok.*;
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
    @OneToOne
    private SectionType sectionType;
    @OneToMany
    private List<Parameters> parameters;
}