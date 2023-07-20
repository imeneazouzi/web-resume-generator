package com.elyadata.webResumeGenerator.repo;

import com.elyadata.webResumeGenerator.model.SectionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionTypeRepository extends JpaRepository<SectionType, Long> {

}

