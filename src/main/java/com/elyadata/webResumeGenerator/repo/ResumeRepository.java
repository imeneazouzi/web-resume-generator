package com.elyadata.webResumeGenerator.repo;

import com.elyadata.webResumeGenerator.dto.ResumeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ResumeRepository extends JpaRepository<ResumeDTO, Long> {
    Optional<ResumeDTO> findResumeById(Long id);
    List<ResumeDTO> findByTitle(String title);
}