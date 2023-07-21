package com.elyadata.webResumeGenerator.repo;

import com.elyadata.webResumeGenerator.dto.SectionDTO;
import com.elyadata.webResumeGenerator.model.Section;
import com.elyadata.webResumeGenerator.model.SectionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {

    Optional<Section> findSectionById(Long id);
    public List<Section> findSectionByResumeId(long resumeId);
}
