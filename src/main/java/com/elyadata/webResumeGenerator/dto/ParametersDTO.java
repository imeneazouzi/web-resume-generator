package com.elyadata.webResumeGenerator.dto;

import com.elyadata.webResumeGenerator.model.Section;

import java.time.LocalDate;

public class ParametersDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Section section;
}
