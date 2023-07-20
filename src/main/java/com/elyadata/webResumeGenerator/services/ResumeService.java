package com.elyadata.webResumeGenerator.services;

import com.elyadata.webResumeGenerator.model.Resume;

import java.util.List;

public interface ResumeService {

    public Resume addResume(Resume resume);
    public List<Resume> findAllResume();
    public void deleteResume(Long id);
    public Resume updateResume(Resume resume);
    public Resume findResumeById(Long id);
    public List<Resume> findByTitle(String title);
}
