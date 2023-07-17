package com.elyadata.webResumeGenerator.services.impl;
import com.elyadata.webResumeGenerator.model.Resume;
import com.elyadata.webResumeGenerator.repo.ResumeRepository;
import com.elyadata.webResumeGenerator.execption.ResumeNotFoundException;
import com.elyadata.webResumeGenerator.services.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    private ResumeRepository resumeRepository;
    @Autowired
    public ResumeServiceImpl(ResumeRepository ResumeRepository)
    {
        this.resumeRepository = ResumeRepository;
    }
    @Override
    public Resume addResume(Resume resume) {
        return resumeRepository.save(resume);
    }
    @Override
    public List<Resume> findAllresume() {
        return resumeRepository.findAll();
    }
    @Override
    public void deleteResume(Long id){
        resumeRepository.deleteById(id);
    }
    @Override
    public Resume updateResume(Resume resume,Long id){
        Resume existingResume = resumeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Resume not found with ID: " + id));

        // Update the properties of the existing problem
        existingResume.setTitle(resume.getTitle());
        // ... update other properties as needed
        return resumeRepository.save(existingResume);
    }
    @Override
    public Resume findResumeById(Long id) {
        return resumeRepository.findResumeById(id)
                .orElseThrow(() -> new ResumeNotFoundException("User by id " + id + " was not found"));
    }
    @Override
    public List<Resume> findByTitle(String title) {
        try {
            return resumeRepository.findByTitle(title);
        } catch (Exception e) {
            // Handle the exception
        }
        return null;
    }





}
