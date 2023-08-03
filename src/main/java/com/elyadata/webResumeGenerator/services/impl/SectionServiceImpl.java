package com.elyadata.webResumeGenerator.services.impl;
import com.elyadata.webResumeGenerator.dto.SectionDTO;
import com.elyadata.webResumeGenerator.execption.NotFoundException;
import com.elyadata.webResumeGenerator.mapper.ParametersMapper;
import com.elyadata.webResumeGenerator.mapper.SectionMapper;
import com.elyadata.webResumeGenerator.mapper.SectionTypeMapper;
import com.elyadata.webResumeGenerator.model.Section;
import com.elyadata.webResumeGenerator.repo.SectionRepository;
import com.elyadata.webResumeGenerator.repo.SectionTypeRepository;
import com.elyadata.webResumeGenerator.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class SectionServiceImpl implements SectionService {
    private final SectionRepository sectionRepository;
    private final SectionTypeRepository sectionTypeRepository;
    private final SectionMapper sectionMapper;
    @Autowired
    private SectionTypeMapper sectionTypeMapper;
    @Autowired
    private ParametersMapper parametersMapper;
    public SectionServiceImpl(SectionRepository sectionRepository , SectionMapper sectionMapper,SectionTypeRepository sectionTypeRepository)
    {
        this.sectionRepository = sectionRepository;
        this.sectionMapper = sectionMapper;
        this.sectionTypeRepository=sectionTypeRepository;
    }
    @Override
    public SectionDTO addSection(SectionDTO sectionDto) {
        return sectionMapper.toDto(sectionRepository.save(sectionMapper.toEntity(sectionDto)));
    }
    @Override
    public void deleteSection(Long id){
        sectionRepository.deleteById(id);
    }
    @Override
    public SectionDTO updateSection(SectionDTO sectionDto){
        Section existingSection = sectionRepository.findById(sectionDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Section not found with ID: " + sectionDto.getId()));
        existingSection.setName(sectionDto.getName());
        existingSection.setParameters(sectionMapper.toEntity(sectionDto).getParameters());
        existingSection.setSectionType(sectionMapper.toEntity(sectionDto).getSectionType());
        return sectionMapper.toDto(sectionRepository.save(existingSection));
    }
    @Override
    public SectionDTO findSectionById(Long id) {
        return sectionMapper.toDto(sectionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Section with id " + id + " was not found")));
    }
    @Override
    public List<SectionDTO> findAllSection() {
        return sectionMapper.toDto(sectionRepository.findAll());
    }
}
