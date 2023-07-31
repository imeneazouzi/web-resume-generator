package com.elyadata.webResumeGenerator.repo;
import com.elyadata.webResumeGenerator.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
    Optional<Resume> findResumeById(Long id);
    List<Resume> findByTitle(String title);
    List<Resume> findResumeByUser(Long id);
}