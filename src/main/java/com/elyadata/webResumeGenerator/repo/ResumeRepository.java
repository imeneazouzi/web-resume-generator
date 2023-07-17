package com.elyadata.webResumeGenerator.repo;

import com.elyadata.webResumeGenerator.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
    Optional<Resume> findResumeById(Long id);
    @Query(value = "SELECT p FROM Problem p WHERE p.title= :title")
    List<Resume> findByTitle(@Param("title") String title);



}