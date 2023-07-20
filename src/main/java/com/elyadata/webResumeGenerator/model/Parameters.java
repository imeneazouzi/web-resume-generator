package com.elyadata.webResumeGenerator.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parameters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    private Section section;


}
