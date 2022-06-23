package com.example.votingservice.dao;

import com.example.votingservice.model.VotingInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotingInfoEntityDao extends JpaRepository<VotingInfoEntity,Integer> {
}
