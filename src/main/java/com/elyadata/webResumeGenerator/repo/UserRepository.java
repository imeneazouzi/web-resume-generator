package com.elyadata.webResumeGenerator.repo;

import com.elyadata.webResumeGenerator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserById(Long id);

    List<User> findByEmail(String email);
}