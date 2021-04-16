package com.example.authentication.repository;

import com.example.authentication.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

    @Query("SELECT l FROM Login l where l.email = ?1 AND l.password = ?2")
    Optional<Login> findByEmailAndPassword(String email, String pwd);
}
