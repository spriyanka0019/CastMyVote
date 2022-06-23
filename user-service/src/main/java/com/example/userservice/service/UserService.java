package com.example.userservice.service;

import com.example.userservice.model.UserInfoEntity;

import java.util.List;

public interface UserService {
public List<UserInfoEntity> getAllCandidates();
public UserInfoEntity getCandidateById(int id);
public UserInfoEntity registerUser(UserInfoEntity userinfo);
}
