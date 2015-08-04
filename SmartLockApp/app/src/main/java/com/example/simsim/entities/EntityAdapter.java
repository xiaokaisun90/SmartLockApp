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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class EntityAdapter implements AuthenticationInterface, RegistrationInterface,
        ProfileInterface, HistoryInterface, HostSpaceInterface, HostLockInterface,
        HostEventInterface, GuestLockInterface, GuestEventInterface,
        ServletConstantInterface, DatabaseConstantInterface {

    private static Information information = new Information();

    public EntityAdapter() {}

    // Only for debug
    public static Information getInformation() { return information; }

    @Override
    public boolean authenticate(String primaryPhoneNumber, String password) throws Exception{
        information.getUser().setPrimaryPhoneNumber(primaryPhoneNumber);
        information.getUser().setPassword(password);
        String response = (String) HttpConnection.httpPost(URL_AUTHENTICATE, information.getUser());
        if(response.equals(RESPONSE_FAILURE)) return false;
        else return true;
    }

    @Override
    public void loadDataFromDB(String primaryPhoneNumber) throws Exception {
        information.getUser().setPrimaryPhoneNumber(primaryPhoneNumber);
        User user = (User) HttpConnection.httpPost(URL_USER_READ, information.getUser());
        if(user != null) information.setUser(user);
        if(getUserState().equals(USER_STATE_HOST)){
            Map<Property, List<Lock>> hostPropLockMap =
                    (Map<Property, List<Lock>>) HttpConnection.httpPost(URL_LOCK_READ,
                            information.getUser());
            information.setHostPropLockMap(hostPropLockMap);
        }
        else{
            List<Lock> guestLock =
                    (List<Lock>) HttpConnection.httpPost(URL_LOCK_READ, information.getUser());
            information.setGuestLock(guestLock);
        }
        Map<Lock, List<LockActivity>> lockLockActivityMap =
                (Map<Lock, List<LockActivity>>) HttpConnection.httpPost(URL_LOCK_ACTIVITY_READ,
                        information.getUser());
        information.setLockLockActivityMap(lockLockActivityMap);
    }

    @Override
    public List<LockActivity> getFutureLockActivity() {
        List<LockActivity> futureLockActivity = new ArrayList<LockActivity>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd" , Locale.US);
        Date currentDate = new Date();
        long longCurrentDate = currentDate.getTime();
        try{
            for(List<LockActivity> lockActivityList
                    : information.getLockLockActivityMap().values()){
                for(LockActivity lockActivity : lockActivityList){
                    Date dateAccessEndTime
                            = simpleDateFormat.parse(lockActivity.getAccessEndTime());
                    long longAccessEndTime = dateAccessEndTime.getTime();
                    if((longAccessEndTime > longCurrentDate) && (lockActivity.getRequestStatus()
                            .equals(LOCK_ACTIVITY_REQUEST_STATUS_REJECT) == false)){
                        futureLockActivity.add(lockActivity);
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return futureLockActivity;
    }

    @Override
    public void updateLockActivity(LockActivity lockActivity) throws Exception{
        HttpConnection.httpPost(URL_LOCK_ACTIVITY_UPDATE, lockActivity);
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
        List<LockActivity> historyLockActivity = new ArrayList<LockActivity>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd" , Locale.US);
        Date currentDate = new Date();
        long longCurrentDate = currentDate.getTime();
        try{
            for(List<LockActivity> lockActivityList
                    : information.getLockLockActivityMap().values()){
                for(LockActivity lockActivity : lockActivityList){
                    Date dateAccessEndTime
                            = simpleDateFormat.parse(lockActivity.getAccessEndTime());
                    long longAccessEndTime = dateAccessEndTime.getTime();
                    if(longAccessEndTime < longCurrentDate){
                        historyLockActivity.add(lockActivity);
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return historyLockActivity;
    }

    @Override
    public List<Lock> getAllLockList() {
        List<Lock> lockList = new ArrayList<Lock>();
        for(List<Lock> sublist : information.getHostPropLockMap().values()){
            lockList.addAll(sublist);
        }
        return lockList;
    }

    @Override
    public List<Property> getPropertyList() {
        List<Property> propertyList = new ArrayList<Property>();
        for(Property property : information.getHostPropLockMap().keySet()){
            propertyList.add(property);
        }
        return propertyList;
    }

    @Override
    public int getLockNumberOfProperty(Property property){
        return information.getHostPropLockMap().get(property).size();
    }

    @Override
    public void insertProperty(Property property) throws Exception{
        HttpConnection.httpPost(URL_PROPERTY_CREATE, property);
        information.getHostPropLockMap().put(property, new ArrayList<Lock>());
    }

    @Override
    public void updateProperty(Property property) throws Exception{
        HttpConnection.httpPost(URL_PROPERTY_UPDATE, property);
    }

    @Override
    public void deleteProperty(Property property) throws Exception{
        HttpConnection.httpPost(URL_PROPERTY_DELETE, property);
    }

    @Override
    public List<Lock> getLockList(Property property) {
        return information.getHostPropLockMap().get(property);
    }

    @Override
    public void insertLock(Property property, Lock lock) throws Exception{
        HttpConnection.httpPost(URL_LOCK_CREATE, lock);
        information.getHostPropLockMap().get(property).add(lock);
    }

    @Override
    public void updateLock(Property property, Lock lock) throws Exception{
        HttpConnection.httpPost(URL_LOCK_UPDATE, lock);
    }

    @Override
    public void deleteLock(Property property, Lock lock) throws Exception{
        HttpConnection.httpPost(URL_LOCK_DELETE, lock);
    }

    @Override
    public void updateProfile(String dataOfBirth, String gender, String emailAddress,
                              int zipCode, String icon) throws Exception{
        information.getUser().setDataOfBirth(dataOfBirth);
        information.getUser().setGender(gender);
        information.getUser().setEmailAddress(emailAddress);
        information.getUser().setZipCode(zipCode);
        information.getUser().setIcon(icon);
        HttpConnection.httpPost(URL_USER_UPDATE, information.getUser());
    }

    @Override
    public String getUserState() {
        return information.getUser().getUserState();
    }

    @Override
    public String getDateOfBirth() {
        return information.getUser().getDataOfBirth();
    }

    @Override
    public String getGender() {
        return information.getUser().getGender();
    }

    @Override
    public String getEmailAddress() {
        return information.getUser().getEmailAddress();
    }

    @Override
    public int getZipCode() {
        return information.getUser().getZipCode();
    }

    @Override
    public String getIcon() {
        return information.getUser().getIcon();
    }

    @Override
    public void setBasicUserInfo(String name, String password, String country,
                                 String primaryPhoneNumber, String userState) {
        information.getUser().setName(name);
        information.getUser().setPassword(password);
        information.getUser().setCountry(country);
        information.getUser().setPrimaryPhoneNumber(primaryPhoneNumber);
        information.getUser().setUserState(userState);
        information.getUser().setDataOfBirth(USER_BIRTHDAY_DEFAULT);
        information.getUser().setGender(USER_GENDER_DEFAULT);
    }

    @Override
    public boolean insertUser() throws Exception{
        String response = (String) HttpConnection.httpPost(URL_USER_CREATE, information.getUser());
        if(response.equals(RESPONSE_SUCCESS)) return true;
        else return false;
    }

}
