package com.elyadata.webResumeGenerator.services;

import com.elyadata.webResumeGenerator.dto.SectionDTO;

import java.util.List;

public interface SectionService {
    public SectionDTO addSection(SectionDTO sectionDto);
    public void deleteSection(Long id);
    public SectionDTO updateSection(SectionDTO sectionDto);
    public SectionDTO findSectionById(Long id);
    public List<SectionDTO> findAllSection();
    public List<SectionDTO> findSectionByResumeId(long resumeId);
}
