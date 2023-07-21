package com.elyadata.webResumeGenerator.repo;

import com.elyadata.webResumeGenerator.dto.SectionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<SectionDTO, Long> {


}
