package com.elyadata.webResumeGenerator.services;

import com.elyadata.webResumeGenerator.model.SectionType;

import java.util.List;

public interface SectionTypeService {

    public SectionType addSectionType(SectionType sectionType);
    public void deleteSectionType(Long id);
    public SectionType updateSectionType(SectionType sectionType);
    public SectionType findSectionTypeById(Long id);
    public List<SectionType> findAllSectionType();
}
