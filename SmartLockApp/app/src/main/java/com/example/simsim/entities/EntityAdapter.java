package com.example.simsim.entities;


import com.example.simsim.database.DatabaseConstantInterface;
import com.example.simsim.interfaces.AuthenticationInterface;
import com.example.simsim.interfaces.GuestEventInterface;
import com.example.simsim.interfaces.GuestLockInterface;
import com.example.simsim.interfaces.HistoryInterface;
import com.example.simsim.interfaces.HostEventInterface;
import com.example.simsim.interfaces.HostLockInterface;
import com.example.simsim.interfaces.HostSpaceInterface;
import com.example.simsim.interfaces.ProfileInterface;
import com.example.simsim.interfaces.RegistrationInterface;
import com.example.simsim.local.HttpConnection;
import com.example.simsim.local.ServletConstantInterface;

import java.util.List;
import java.util.Map;

public class EntityAdapter implements AuthenticationInterface, RegistrationInterface,
        ProfileInterface, HistoryInterface, HostSpaceInterface, HostLockInterface,
        HostEventInterface, GuestLockInterface, GuestEventInterface,
        ServletConstantInterface, DatabaseConstantInterface {

    private static Information information = new Information();

    public EntityAdapter() {}

    @Override
    public boolean authenticate(String primaryPhoneNumber, String password) throws Exception{
        information.getUser().setPrimaryPhoneNumber(primaryPhoneNumber);
        information.getUser().setPassword(password);
        String response = (String) HttpConnection.httpPost(URL_AUTHENTICATE, information.getUser());
        if(response.equals(RESPONSE_SUCCESS)) return true;
        else return false;
    }

    @Override
    public void loadDataFromDB(String primaryPhoneNumber) throws Exception {
        information.getUser().setPrimaryPhoneNumber(primaryPhoneNumber);
        User user = (User) HttpConnection.httpPost(URL_USER_READ, information.getUser());
        information.setUser(user);
        if(getUserState().equals(USER_STATE_HOST)){
            Map<Property, List<Lock>> hostPropLockMap =
                    (Map<Property, List<Lock>>) HttpConnection.httpPost(URL_LOCK_READ,
                            information.getUser());
        }
        else{
            List<Lock> guestLock =
                    (List<Lock>) HttpConnection.httpPost(URL_LOCK_READ, information.getUser());

        }
        Map<Lock, List<LockActivity>> lockLockActivityMap =
                (Map<Lock, List<LockActivity>>) HttpConnection.httpPost(URL_LOCK_ACTIVITY_READ,
                        information.getUser());
    }

    @Override
    public List<LockActivity> getFutureLockActivity() {
        return null;
    }

    @Override
    public void updateLockActivity(LockActivity lockActivity) {

    }

    @Override
    public void loadHostIdFromDB(String primaryPhoneNumber) {

    }

    @Override
    public int getGuestId() {
        return 0;
    }

    @Override
    public int getHostId() {
        return 0;
    }

    @Override
    public List<Property> getHostPropertyList(int hostId) {
        return null;
    }

    @Override
    public List<Integer> getHostLockIdList(Property property) {
        return null;
    }

    @Override
    public void setNewLockActivityHostId(int hostId) {

    }

    @Override
    public void setNewLockActivityGuestId(int guestId) {

    }

    @Override
    public void setNewLockActivityLockId(int lockId) {

    }

    @Override
    public void setNewLockActivityAccessStartTime(String accessStartTime) {

    }

    @Override
    public void setNewLockActivityAccessEndTime(String accessEndTime) {

    }

    @Override
    public void setNewLockActivityRequestAccessTimestamp(String requestAccessTimestamp) {

    }

    @Override
    public void setNewLockActivityRequestStatus(boolean requestStatus) {

    }

    @Override
    public void setNewLockActivityAlert(int alert) {

    }

    @Override
    public void insertNewLockActivity() {

    }

    @Override
    public boolean openLock(Lock lock) {
        return false;
    }

    @Override
    public boolean closeLock(Lock lock) {
        return false;
    }

    @Override
    public List<LockActivity> getHistoryLockActivity() {
        return null;
    }

    @Override
    public List<Lock> getLockList() {
        return null;
    }

    @Override
    public List<Property> getPropertyList() {
        return null;
    }

    @Override
    public void insertProperty(Property property) {

    }

    @Override
    public void updateProperty(Property property) {

    }

    @Override
    public void deleteProperty(Property property) {

    }

    @Override
    public List<Lock> getLockList(Property property) {
        return null;
    }

    @Override
    public void insertLock(Property property, Lock lock) {

    }

    @Override
    public void updateLock(Property property, Lock lock) {

    }

    @Override
    public void deleteLock(Property property, Lock lock) {

    }

    @Override
    public void updateProfile(String userState, String dataOfBirth, String gender, String emailAddress, int zipCode, String icon) {

    }

    @Override
    public String getUserState() {
        return information.getUser().getUserState();
    }

    @Override
    public String getDateOfBirth() {
        return null;
    }

    @Override
    public String getGender() {
        return null;
    }

    @Override
    public String getEmailAddress() {
        return null;
    }

    @Override
    public int getZipCode() {
        return 0;
    }

    @Override
    public String getIcon() {
        return null;
    }

    @Override
    public void setBasicUserInfo(String name, String password, String country, String primaryPhoneNumber) {

    }

    @Override
    public void insertUser() {

    }

}
