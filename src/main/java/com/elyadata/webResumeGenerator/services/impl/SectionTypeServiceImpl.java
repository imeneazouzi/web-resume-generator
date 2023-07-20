package com.elyadata.webResumeGenerator.services.impl;

import com.elyadata.webResumeGenerator.execption.NotFoundException;
import com.elyadata.webResumeGenerator.model.SectionType;
import com.elyadata.webResumeGenerator.repo.SectionTypeRepository;
import com.elyadata.webResumeGenerator.services.SectionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionTypeServiceImpl implements SectionTypeService {

    @Autowired
    private SectionTypeRepository sectionTypeRepository;
    @Autowired
    public SectionTypeServiceImpl(SectionTypeRepository sectionTypeRepository)
    {
        this.sectionTypeRepository = sectionTypeRepository;
    }
    @Override
    public SectionType addSectionType(SectionType sectionType) {
        return sectionTypeRepository.save(sectionType);
    }
    @Override
    public void deleteSectionType(Long id){
        sectionTypeRepository.deleteById(id);
    }
    @Override
    public SectionType updateSectionType(SectionType sectionType){
        SectionType existingSectionType = sectionTypeRepository.findById(sectionType.getId())
                .orElseThrow(() -> new IllegalArgumentException("SectionType not found with ID: " + sectionType.getId()));
        existingSectionType.setType(sectionType.getType());
        return sectionTypeRepository.save(existingSectionType);
    }

    @Override
    public SectionType findSectionTypeById(Long id) {
        return sectionTypeRepository.findSectionTypeById(id)
                .orElseThrow(() -> new NotFoundException("SectionType by id " + id + " was not found"));
    }

    @Override
    public List<SectionType> findAllSectionType() {
        return sectionTypeRepository.findAll();
    }


}
