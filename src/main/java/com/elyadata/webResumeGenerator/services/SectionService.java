package com.elyadata.webResumeGenerator.services;

import com.elyadata.webResumeGenerator.dto.SectionDTO;

import java.util.List;

public interface SectionService {
    SectionDTO addSection(SectionDTO sectionDto);
    void deleteSection(Long id);
     SectionDTO updateSection(SectionDTO sectionDto);
     SectionDTO findSectionById(Long id);
    List<SectionDTO> findAllSection();
     List<SectionDTO> findSectionByResumeId(long resumeId);
}
