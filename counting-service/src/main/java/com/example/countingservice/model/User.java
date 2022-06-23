package com.example.countingservice.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;


public class User {
    private String user1 = "Albus Dumbeldore";
    private String user2 = "John Watson";
    private String user3 = "Tulsi Virani";
    private String user4 = "Irene Aler";

    private int usercount1;
    private int usercount2;
    private int usercount3;
    private int usercount4;

    public void setUsercount1(int usercount1) {
        this.usercount1 = usercount1;
    }

    public void setUsercount2(int usercount2) {
        this.usercount2 = usercount2;
    }

    public void setUsercount3(int usercount3) {
        this.usercount3 = usercount3;
    }

    public void setUsercount4(int usercount4) {
        this.usercount4 = usercount4;
    }

    public String getUser1() {
        return user1;
    }

    public String getUser2() {
        return user2;
    }

    public String getUser3() {
        return user3;
    }

    public String getUser4() {
        return user4;
    }

    public int getUsercount1() {
        return usercount1;
    }

    public int getUsercount2() {
        return usercount2;
    }

    public int getUsercount3() {
        return usercount3;
    }

    public int getUsercount4() {
        return usercount4;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("VotingBoard{");
        sb.append("100").append('|').append(getUser1()).append('=').append(getUsercount1()).append(',');
        sb.append("101").append('|').append(getUser2()).append('=').append(getUsercount2()).append(',');
        sb.append("102").append('|').append(getUser3()).append('=').append(getUsercount3()).append(',');
        sb.append("103").append('|').append(getUser4()).append('=').append(getUsercount4()).append(',');
        sb.append('}');
        return sb.toString();
    }
}
