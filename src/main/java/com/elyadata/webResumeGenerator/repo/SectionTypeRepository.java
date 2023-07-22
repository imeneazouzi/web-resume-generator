package com.elyadata.webResumeGenerator.repo;
import com.elyadata.webResumeGenerator.model.SectionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface SectionTypeRepository extends JpaRepository<SectionType, Long> {
    Optional<SectionType> findSectionTypeById(Long id);
     List<SectionType> findSectionTypesBySectionId(long sectionId);
}


