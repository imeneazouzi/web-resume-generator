package com.elyadata.webResumeGenerator.services;

import com.elyadata.webResumeGenerator.dto.SectionTypeDTO;

import java.util.List;

public interface SectionTypeService {

    public SectionTypeDTO addSectionType(SectionTypeDTO sectionTypeDto);
    public void deleteSectionType(Long id);
    public SectionTypeDTO updateSectionType(SectionTypeDTO sectionTypeDto);
    public SectionTypeDTO findSectionTypeById(Long id);
    public List<SectionTypeDTO> findAllSectionType();
    public List<SectionTypeDTO> findSectionTypesBySectionId(long sectionId);
}
