package com.elyadata.webResumeGenerator.services;
import com.elyadata.webResumeGenerator.dto.SectionTypeDTO;
import java.util.List;
public interface SectionTypeService {
     SectionTypeDTO addSectionType(SectionTypeDTO sectionTypeDto);
     void deleteSectionType(Long id);
     SectionTypeDTO updateSectionType(SectionTypeDTO sectionTypeDto);
     SectionTypeDTO findSectionTypeById(Long id);
     List<SectionTypeDTO> findAllSectionType();
}
