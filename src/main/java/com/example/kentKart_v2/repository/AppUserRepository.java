package com.example.kentKart_v2.repository;

import com.example.kentKart_v2.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByAppUserId(Long appUserId);
}
