package com.example.votingservice.controller;

import com.example.votingservice.dao.UserInfoEntityDao;
import com.example.votingservice.dto.VotingInfoEntityDto;
import com.example.votingservice.model.VotingBoard;
import com.example.votingservice.model.VotingInfoEntity;
import com.example.votingservice.service.VotingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/vote_app/v1")
public class VotingServiceController {
    @Autowired
    ModelMapper mapper;

    @Autowired
    VotingService votingService;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;



    @Autowired
    VotingBoard votingBoard;

    @PostMapping(value="/vote",consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getVotingDetails(@RequestBody VotingInfoEntityDto votingDto){
        VotingInfoEntity votingInfoEntity = mapper.map(votingDto,VotingInfoEntity.class);
        VotingInfoEntity receivedEntity = votingService.getCastVoteDetails(votingInfoEntity);

        VotingInfoEntityDto votingdto = mapper.map(receivedEntity,VotingInfoEntityDto.class);
        final StringBuffer sb = new StringBuffer("VotingBoard{");
        sb.append("100").append('|').append(votingBoard.getUser1()).append('=').append(votingBoard.getUsercount1()).append(',');
        sb.append("101").append('|').append(votingBoard.getUser2()).append('=').append(votingBoard.getUsercount2()).append(',');
        sb.append("102").append('|').append(votingBoard.getUser3()).append('=').append(votingBoard.getUsercount3()).append(',');
        sb.append("103").append('|').append(votingBoard.getUser4()).append('=').append(votingBoard.getUsercount4());
        sb.append('}');
        kafkaTemplate.send("VotingBoard",sb.toString());

        return new ResponseEntity(votingdto, HttpStatus.OK);

    }


}
