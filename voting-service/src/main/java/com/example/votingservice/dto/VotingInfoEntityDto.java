package com.example.votingservice.dto;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class VotingInfoEntityDto {

    int voteId;

    int voterId;

    String aadharNumber;

    int candidateId;

}
