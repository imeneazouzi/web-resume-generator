package com.elyadata.webResumeGenerator.repo;
import com.elyadata.webResumeGenerator.model.Parameters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ParametersRepository extends JpaRepository<Parameters, Long> {
    Optional<Parameters> findParametersById(Long id);
}