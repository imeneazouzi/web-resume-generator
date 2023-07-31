package com.elyadata.webResumeGenerator.services.impl;
import com.elyadata.webResumeGenerator.dto.ResumeDTO;
import com.elyadata.webResumeGenerator.mapper.ResumeMapper;
import com.elyadata.webResumeGenerator.model.Resume;
import com.elyadata.webResumeGenerator.repo.ResumeRepository;
import com.elyadata.webResumeGenerator.execption.NotFoundException;
import com.elyadata.webResumeGenerator.services.ResumeService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {
    private final ResumeRepository resumeRepository;
    private final ResumeMapper resumeMapper;
    public ResumeServiceImpl(ResumeRepository resumeRepository ,ResumeMapper resumeMapper)
    {
        this.resumeRepository = resumeRepository;
        this.resumeMapper = resumeMapper;
    }
    @Override
    public ResumeDTO addResume(ResumeDTO resumeDto) {
        return resumeMapper.toDto(resumeRepository.save(resumeMapper.toEntity(resumeDto)));
    }
    @Override
    public List<ResumeDTO> findAllResume() {
        return resumeMapper.toDto(resumeRepository.findAll());
    }
    @Override
    public void deleteResume(Long id){
        resumeRepository.deleteById(id);
    }
    @Override
    public ResumeDTO updateResume(ResumeDTO resumeDto){
        Resume existingResume = resumeRepository.findById(resumeDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Resume not found with ID: " + resumeDto.getId()));
        existingResume.setTitle(resumeDto.getTitle());
        existingResume.setSections(resumeDto.getSections());
        return resumeMapper.toDto(resumeRepository.save(existingResume));
    }
    @Override
    public ResumeDTO findResumeById(Long id) {
        return resumeMapper.toDto(resumeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("resumeDto with id " + id + " was not found")));
    }
    @Override
    public List<ResumeDTO> findByTitle(String title) {
            return resumeMapper.toDto(resumeRepository.findByTitle(title));
    }
}
