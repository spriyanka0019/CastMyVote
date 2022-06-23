package com.example.votingservice.model;

import com.example.votingservice.dao.UserInfoEntityDao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
public class VotingBoard {


    private final String user1 = "Irene Adler";
    private final String user2 = "John Watson";
    private final String user3 = "Tulsi Virani";
    private final String user4 = "Albus Dumbeldore";

    private int usercount1=0;
    private int usercount2=0;
    private int usercount3=0;
    private int usercount4=0;



//    @Override
//    public String toString() {
//        final StringBuffer sb = new StringBuffer("VotingBoard{");
//        sb.append("100").append('|').append(getUser1()).append('=').append(getUsercount1()).append(',');
//        sb.append("101").append('|').append(getUser2()).append('=').append(getUsercount2()).append(',');
//        sb.append("102").append('|').append(getUser3()).append('=').append(getUsercount3()).append(',');
//        sb.append("103").append('|').append(getUser4()).append('=').append(getUsercount4()).append(',');
//        sb.append('}');
//        return sb.toString();
//    }
}
