package com.elyadata.webResumeGenerator.services.impl;
import com.elyadata.webResumeGenerator.dto.SectionTypeDTO;
import com.elyadata.webResumeGenerator.execption.NotFoundException;
import com.elyadata.webResumeGenerator.mapper.SectionTypeMapper;
import com.elyadata.webResumeGenerator.model.SectionType;
import com.elyadata.webResumeGenerator.repo.SectionTypeRepository;
import com.elyadata.webResumeGenerator.services.SectionTypeService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class SectionTypeServiceImpl implements SectionTypeService {
    private final SectionTypeRepository sectionTypeRepository;
    private final SectionTypeMapper sectionTypeMapper;
    public SectionTypeServiceImpl(SectionTypeRepository sectionTypeRepository , SectionTypeMapper sectionTypeMapper)
    {
        this.sectionTypeRepository = sectionTypeRepository;
        this.sectionTypeMapper = sectionTypeMapper;
    }
    @Override
    public SectionTypeDTO addSectionType(SectionTypeDTO sectionTypeDto) {
        return sectionTypeMapper.toDto(sectionTypeRepository.save(sectionTypeMapper.toEntity(sectionTypeDto)));
    }
    @Override
    public void deleteSectionType(Long id){
        sectionTypeRepository.deleteById(id);
    }
    @Override
    public SectionTypeDTO updateSectionType(SectionTypeDTO sectionTypeDto){
        SectionType existingSectionType = sectionTypeRepository.findById(sectionTypeDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("SectionType not found with ID: " + sectionTypeDto.getId()));
        existingSectionType.setType(sectionTypeDto.getType());
        return sectionTypeMapper.toDto(sectionTypeRepository.save(existingSectionType));
    }
    @Override
    public SectionTypeDTO findSectionTypeById(Long id) {
        return sectionTypeMapper.toDto(sectionTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("SectionType with id " + id + " was not found")));
    }
    @Override
    public List<SectionTypeDTO> findAllSectionType() {
        return sectionTypeMapper.toDto(sectionTypeRepository.findAll());
    }
}
