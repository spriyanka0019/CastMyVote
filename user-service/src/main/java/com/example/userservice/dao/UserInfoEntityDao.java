package com.example.userservice.dao;

import com.example.userservice.model.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoEntityDao extends JpaRepository<UserInfoEntity,Integer> {
}
