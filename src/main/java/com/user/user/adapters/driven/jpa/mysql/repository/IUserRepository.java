package com.user.user.adapters.driven.jpa.mysql.repository;

import com.user.user.adapters.driven.jpa.mysql.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {

        @Query("SELECT e FROM UserEntity e WHERE e.dni LIKE %:document%")
        UserEntity findByDni(@Param("document") String document);
        UserEntity findByEmail(String email);

}
