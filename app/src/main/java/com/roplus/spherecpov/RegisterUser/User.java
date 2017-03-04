package com.roplus.spherecpov.RegisterUser;

import java.util.ArrayList;

/**
 * Created by test on 04-Mar-17.
 */

public class User {

    private int checkIns;
    private String emailAddress, emailDomain, firstName, lastName, membership, username;

    //private String[] attributes = {"username","firstName","lastName","emailAddress", "emailDomain", "membership", "checkIns"};

    public User(String firstName, String lastName, String emailAddress, String emailDomain){
        this.checkIns = 0;
        this.emailAddress = emailAddress;
        this.emailDomain = emailDomain;
        this.firstName = firstName;
        this.lastName = lastName;
        this.membership = "No";
        this.username = firstName+lastName;
    }

    public int getCheckIns() {
        return checkIns;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getEmailDomain() {
        return emailDomain;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMembership() {
        return membership;
    }

    public String getUsername() {
        return username;
    }

    //public String[] getAttributes() { return attributes; }

    public User(){

    }
}
