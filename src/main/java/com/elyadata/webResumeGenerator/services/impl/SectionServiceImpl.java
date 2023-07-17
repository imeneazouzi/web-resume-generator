package com.elyadata.webResumeGenerator.services.impl;

import com.elyadata.webResumeGenerator.model.Section;
import com.elyadata.webResumeGenerator.model.SectionType;
import com.elyadata.webResumeGenerator.repo.SectionRepository;
import com.elyadata.webResumeGenerator.repo.SectionTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
@Transactional

public class SectionServiceImpl {
    private final SectionRepository sectionRepository;
    private final SectionTypeRepository sectionTypeRepository;

    public SectionServiceImpl(SectionRepository sectionRepository, SectionTypeRepository sectionTypeRepository) {
        this.sectionRepository = sectionRepository;
        this.sectionTypeRepository = sectionTypeRepository;
    }

    public void createSectionWithSectionType(String sectionName, String sectionTypeName) {
        Section section = new Section();
        section.setName(sectionName);

        SectionType sectionType = new SectionType();
        sectionType.setType(sectionTypeName);

        section.setSectionType(sectionType);
        sectionType.setSection(section);

        sectionRepository.save(section);
    }

}
