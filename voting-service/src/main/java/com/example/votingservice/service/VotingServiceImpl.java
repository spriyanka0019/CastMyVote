package com.example.votingservice.service;

import com.example.votingservice.dao.UserInfoEntityDao;
import com.example.votingservice.dao.VotingInfoEntityDao;
import com.example.votingservice.dto.UserInfoEntityDto;
import com.example.votingservice.exception.RecordNotFoundException;
import com.example.votingservice.exception.UserNotAllowedException;
import com.example.votingservice.feign.VotingServiceClient;
import com.example.votingservice.model.UserInfoEntity;
import com.example.votingservice.model.VotingBoard;
import com.example.votingservice.model.VotingInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Service
public class VotingServiceImpl implements VotingService {
    @Autowired
    UserInfoEntityDao userInfoEntityDao;

    @Autowired
    VotingInfoEntityDao votingInfoEntityDao;

    @Autowired
    private VotingServiceClient votingServiceClient;

    @Autowired
    private VotingBoard votingBoard;
    @Override
    public VotingInfoEntity getCastVoteDetails(VotingInfoEntity votingInfoEntity) throws
            RecordNotFoundException, UserNotAllowedException {
            boolean isUserAlreadyVoted = findByID(votingInfoEntity.getVoterId());

        UserInfoEntityDto userinfo;
        if(!isUserAlreadyVoted) {
                try {
                    userinfo = votingServiceClient.fetchUserDetails(votingInfoEntity.getVoterId());
                }catch(Exception e){
                    throw new RecordNotFoundException("User Not Registered");
                }

                VotingInfoEntity votingInfoEntity1 = new VotingInfoEntity();
                votingInfoEntity1.setAadharNumber(votingInfoEntity.getAadharNumber());
                votingInfoEntity1.setVoterId(userinfo.getUserID());
                votingInfoEntity1.setCandidateId(votingInfoEntity.getCandidateId());


                if (votingInfoEntity.getCandidateId() == 100) {
                    votingBoard.setUsercount1(votingBoard.getUsercount1() + 1);
                } else if (votingInfoEntity.getCandidateId() == 101) {
                    votingBoard.setUsercount2(votingBoard.getUsercount2() + 1);
                } else if (votingInfoEntity.getCandidateId() == 102) {
                    votingBoard.setUsercount3(votingBoard.getUsercount3() + 1);
                } else if (votingInfoEntity.getCandidateId() == 103) {
                    votingBoard.setUsercount4(votingBoard.getUsercount4() + 1);
                }

                votingInfoEntityDao.save(votingInfoEntity1);

                return votingInfoEntity1;
            }else{
                throw new UserNotAllowedException("User has already cast his/her vote");
            }
    }

    private boolean findByID(int id){
        VotingInfoEntity votingInfoEntity = votingInfoEntityDao.findById(id).orElse(null);
        if(votingInfoEntity!=null){
            return true;
        }
        return false;
    }



}
