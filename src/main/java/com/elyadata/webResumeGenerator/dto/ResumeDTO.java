package com.elyadata.webResumeGenerator.dto;
import com.elyadata.webResumeGenerator.model.Section;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeDTO {
    private Long id;
    private  String title;
    private List<SectionDTO> sections;
}
