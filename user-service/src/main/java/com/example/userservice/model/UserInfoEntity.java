package com.example.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class UserInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int userID;

    @Column(name="user_name")
    private String userName;


    @Column(name="aadhar_number")
    private String aadharNumber;


    @Column(name="address")
    private String address;

    @Column(name="dob")
    private LocalDate dateOfBirth;

    @Column(name="roles")
    private String roles;


}
