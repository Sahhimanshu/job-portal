package com.example.job_portal.repository;

import com.example.job_portal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
     User findByUsername(String username);
}
