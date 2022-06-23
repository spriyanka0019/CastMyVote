package com.example.votingservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Component
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

    private String userName;

    private String aadharNumber;

    private String address;

    private LocalDate dateOfBirth;

    private String roles;

}
