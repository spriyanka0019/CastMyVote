package com.example.votingservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;


@Setter
@Getter
public class UserInfoEntityDto {
    int userID;

    private String userName;

    private String aadharNumber;

    private String address;

    private LocalDate dateOfBirth;

    private String roles;


}
