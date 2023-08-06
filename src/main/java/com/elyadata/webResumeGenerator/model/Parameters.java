package com.elyadata.webResumeGenerator.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import com.elyadata.webResumeGenerator.utils.Constants;


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
    private String place;
    @Column(length = Constants.SUMMARY_LENGTH)
    private String summary;


}
