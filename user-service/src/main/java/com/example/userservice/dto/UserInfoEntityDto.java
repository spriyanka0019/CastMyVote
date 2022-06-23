package com.example.userservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoEntityDto {
    int userID;

    private String userName;

    private String aadharNumber;

    private String address;

    private LocalDate dateOfBirth;

    private String roles;

}
