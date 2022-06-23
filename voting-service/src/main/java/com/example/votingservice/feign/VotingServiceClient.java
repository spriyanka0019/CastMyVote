package com.example.votingservice.feign;


import com.example.votingservice.dto.UserInfoEntityDto;
import com.example.votingservice.exception.RecordNotFoundException;
import com.example.votingservice.model.UserInfoEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@FeignClient(name="API-GATEWAY")
public interface VotingServiceClient {
    @RequestMapping(value="/user_app/v1/user/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
     UserInfoEntityDto fetchUserDetails(@PathVariable("id") int id )  ;
}
