package com.elyadata.webResumeGenerator.repo;
import com.elyadata.webResumeGenerator.dto.SectionTypeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface SectionTypeRepository extends JpaRepository<SectionTypeDTO, Long> {
    Optional<SectionTypeDTO> findSectionTypeById(Long id);
    public List<SectionTypeDTO> findSectionTypesBySectionId(long sectionId);
}


