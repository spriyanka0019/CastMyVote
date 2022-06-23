package com.example.votingservice.dao;

import com.example.votingservice.model.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoEntityDao extends JpaRepository<UserInfoEntity,Integer> {
}
