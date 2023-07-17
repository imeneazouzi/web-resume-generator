package com.elyadata.webResumeGenerator.repo;

import com.elyadata.webResumeGenerator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}