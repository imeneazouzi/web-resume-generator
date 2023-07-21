package com.elyadata.webResumeGenerator.services;

import com.elyadata.webResumeGenerator.dto.ResumeDTO;
import com.elyadata.webResumeGenerator.model.Resume;

import java.util.List;

public interface ResumeService {

    public ResumeDTO addResume(ResumeDTO resumeDto);
    public List<ResumeDTO> findAllResume();
    public void deleteResume(Long id);
    public ResumeDTO updateResume(ResumeDTO resumeDto);
    public ResumeDTO findResumeById(Long id);
    public List<ResumeDTO> findByTitle(String title);
}
