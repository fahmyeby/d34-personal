package com.example.d34_backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.d34_backend.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {}
