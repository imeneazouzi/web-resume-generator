package com.elyadata.webResumeGenerator.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SectionDTO {
    private Long id;
    private String name;
    private SectionTypeDTO sectionType;
    private List<ParametersDTO> parameters;
}
