package com.example.simsim.interfaces;

/**
 * Created by Steven on 7/23/15.
 */
public interface AuthenticationInterface {
     boolean authenticate(String primaryPhoneNumber, String password);// If success, return true
     void loadDataFromDB(String primaryPhoneNumber);
     String getUserState();
}
