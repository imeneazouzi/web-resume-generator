package com.elyadata.webResumeGenerator.repo;

import com.elyadata.webResumeGenerator.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {


}
