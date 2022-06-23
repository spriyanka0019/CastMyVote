package com.example.userservice.service;

import com.example.userservice.dao.UserInfoEntityDao;
import com.example.userservice.exception.UserNotAllowedException;
import com.example.userservice.model.UserInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserInfoEntityDao userInfoEntityDao;

    @Override
    public List<UserInfoEntity> getAllCandidates() {
        return userInfoEntityDao.findAll();
    }

    @Override
    public UserInfoEntity getCandidateById(int id) {
        UserInfoEntity getUser = userInfoEntityDao.findById(id).orElse(null);
        return getUser;
    }

    @Override
    public UserInfoEntity registerUser(UserInfoEntity userinfo) throws UserNotAllowedException{
        UserInfoEntity newUser = new UserInfoEntity();

        newUser.setAadharNumber(userinfo.getAadharNumber());
        newUser.setUserName(userinfo.getUserName());
        newUser.setRoles(userinfo.getRoles());
        newUser.setDateOfBirth(userinfo.getDateOfBirth());
        newUser.setAddress(userinfo.getAddress());
        LocalDate date = LocalDate.now();
        int age = Period.between(userinfo.getDateOfBirth(), date).getYears();

        if(age>=18){
            userInfoEntityDao.save(newUser);
            System.out.println("Added new user");
            return newUser;
        }else{
            throw new UserNotAllowedException("User is minor, hence not allowed to vote");
        }



    }
}
