package com.user.user.adapters.driven.jpa.mysql.repository;

import com.user.user.adapters.driven.jpa.mysql.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {

        @Query("SELECT e FROM UserEntity e WHERE e.dni LIKE %:document%")
        UserEntity findByDni(@Param("document") String document);
        Optional<UserEntity> findByEmail(String email);
        List<UserEntity> findAllById(Long id);
}
