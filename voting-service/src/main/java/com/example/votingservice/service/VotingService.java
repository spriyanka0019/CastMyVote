package com.example.votingservice.service;

import com.example.votingservice.model.VotingInfoEntity;

public interface VotingService {
    public VotingInfoEntity getCastVoteDetails(VotingInfoEntity info);

}
