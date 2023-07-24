package com.elyadata.webResumeGenerator.dto;
import com.elyadata.webResumeGenerator.model.Parameters;
import com.elyadata.webResumeGenerator.model.SectionType;
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
    private SectionType sectionType;
    private List<Parameters> parameters;
}
