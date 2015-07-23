package com.example.simsim.interfaces;

import com.example.simsim.entities.LockActivity;
import com.example.simsim.entities.Property;

import java.util.List;

/**
 * Created by Steven on 7/23/15.
 */
public interface GuestEventInterface {//events

    List<LockActivity> getFutureLockActivity();
    void updateLockActivity(LockActivity lockActivity);
    void loadHostIdFromDB(String primaryPhoneNumber);
    int getGuestId();
    int getHostId();
    List<Property> getHostPropertyList(int hostId);
    List<Integer> getHostLockIdList(Property property);
    void setNewLockActivityHostId(int hostId);
    void setNewLockActivityGuestId(int guestId);
    void setNewLockActivityLockId(int lockId);
    void setNewLockActivityAccessStartTime(String accessStartTime);
    void setNewLockActivityAccessEndTime(String accessEndTime);
    void setNewLockActivityRequestAccessTimestamp(String requestAccessTimestamp);
    void setNewLockActivityRequestStatus(boolean requestStatus);
    void setNewLockActivityAlert(int alert);
    void insertNewLockActivity(); // Insert new lockActivity to DB, set lockActivityId to LockActivity object in Information.


}
