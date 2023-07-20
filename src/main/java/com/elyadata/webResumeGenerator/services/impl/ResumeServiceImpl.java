package com.elyadata.webResumeGenerator.services.impl;
import com.elyadata.webResumeGenerator.model.Resume;
import com.elyadata.webResumeGenerator.repo.ResumeRepository;
import com.elyadata.webResumeGenerator.execption.NotFoundException;
import com.elyadata.webResumeGenerator.services.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    private ResumeRepository resumeRepository;
    @Autowired
    public ResumeServiceImpl(ResumeRepository resumeRepository)
    {
        this.resumeRepository = resumeRepository;
    }
    @Override
    public Resume addResume(Resume resume) {
        return resumeRepository.save(resume);
    }
    @Override
    public List<Resume> findAllResume() {
        return resumeRepository.findAll();
    }
    @Override
    public void deleteResume(Long id){
        resumeRepository.deleteById(id);
    }
    @Override
    public Resume updateResume(Resume resume){
        Resume existingResume = resumeRepository.findById(resume.getId())
                .orElseThrow(() -> new IllegalArgumentException("Resume not found with ID: " + resume.getId()));
        existingResume.setTitle(resume.getTitle());
        return resumeRepository.save(existingResume);
    }
    @Override
    public Resume findResumeById(Long id) {
        return resumeRepository.findResumeById(id)
                .orElseThrow(() -> new NotFoundException("User by id " + id + " was not found"));
    }
    @Override
    public List<Resume> findByTitle(String title) {
        try {
            return resumeRepository.findByTitle(title);
        } catch (Exception e) {
        }
        return null;
    }





}
