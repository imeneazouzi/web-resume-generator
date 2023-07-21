package com.elyadata.webResumeGenerator.dto;

import com.elyadata.webResumeGenerator.model.Resume;
import com.elyadata.webResumeGenerator.model.SectionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SectionDTO {
    private Long id;
    private String name;
    private Resume resume;
    private SectionType sectionType;
}
