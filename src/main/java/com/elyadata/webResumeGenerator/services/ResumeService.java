package com.elyadata.webResumeGenerator.services;
import com.elyadata.webResumeGenerator.dto.ResumeDTO;
import java.util.List;
public interface ResumeService {
    ResumeDTO addResume(ResumeDTO resumeDto);
    List<ResumeDTO> findAllResume();
    void deleteResume(Long id);
     ResumeDTO updateResume(ResumeDTO resumeDto);
     ResumeDTO findResumeById(Long id);
    List<ResumeDTO> findByTitle(String title);
}
