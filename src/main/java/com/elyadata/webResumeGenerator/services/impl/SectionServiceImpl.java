package com.elyadata.webResumeGenerator.services.impl;
import com.elyadata.webResumeGenerator.dto.SectionDTO;
import com.elyadata.webResumeGenerator.execption.NotFoundException;
import com.elyadata.webResumeGenerator.mapper.ParametersMapper;
import com.elyadata.webResumeGenerator.mapper.SectionMapper;
import com.elyadata.webResumeGenerator.mapper.SectionTypeMapper;
import com.elyadata.webResumeGenerator.model.Section;
import com.elyadata.webResumeGenerator.repo.SectionRepository;
import com.elyadata.webResumeGenerator.services.SectionService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class SectionServiceImpl implements SectionService {
    private final SectionRepository sectionRepository;
    private final SectionMapper sectionMapper;
    private final SectionTypeMapper sectionTypeMapper;
    private final ParametersMapper parametersMapper;
    public SectionServiceImpl(SectionRepository sectionRepository , SectionMapper sectionMapper, SectionTypeMapper sectionTypeMapper, ParametersMapper parametersMapper)
    {
        this.sectionRepository = sectionRepository;
        this.sectionMapper = sectionMapper;
        this.sectionTypeMapper = sectionTypeMapper;
        this.parametersMapper = parametersMapper;
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
        existingSection.setParameters(parametersMapper.toEntity(sectionDto.getParameters()));
        existingSection.setSectionType(sectionTypeMapper.toEntity(sectionDto.getSectionType()));
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
