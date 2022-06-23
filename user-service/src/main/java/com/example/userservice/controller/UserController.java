package com.example.userservice.controller;

import com.example.userservice.dto.UserInfoEntityDto;
import com.example.userservice.exception.RecordNotFoundException;
import com.example.userservice.model.UserInfoEntity;
import com.example.userservice.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/user_app/v1")

public class UserController {
    @Autowired
    ModelMapper mapper;

    @Autowired
    UserService userService;


    @PostMapping(value="/user/register", consumes= MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registerUser(@RequestBody UserInfoEntityDto userinfodto){

        UserInfoEntity newUserInfo = mapper.map(userinfodto,UserInfoEntity.class);
        UserInfoEntity savedUser = userService.registerUser(newUserInfo);

        UserInfoEntityDto userdto = mapper.map(savedUser, UserInfoEntityDto.class);
        return new ResponseEntity(userdto, HttpStatus.CREATED);
    }


    @GetMapping(value="/candidates",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUsers(){
        List<UserInfoEntityDto> infodto = new ArrayList<>();

        List<UserInfoEntity> userlist = userService.getAllCandidates();
        for(UserInfoEntity info:userlist){
            infodto.add(mapper.map(info,UserInfoEntityDto.class));
        }
        return new ResponseEntity(infodto,HttpStatus.OK);
    }

    @GetMapping(value="/user/{userID}",produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUsers(@PathVariable("userID") int userID) throws RecordNotFoundException {
        UserInfoEntity entity = userService.getCandidateById(userID);
        if(entity!=null) {
            UserInfoEntityDto userDto = mapper.map(entity, UserInfoEntityDto.class);
            return new ResponseEntity(userDto, HttpStatus.OK);
        }else{
            throw   new RecordNotFoundException("User Not Registered Exception");
        }
    }
}
