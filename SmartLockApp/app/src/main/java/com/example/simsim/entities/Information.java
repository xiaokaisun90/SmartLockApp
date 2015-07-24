package com.example.simsim.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Information {

    // Store the data get from database
    private static User user;
    private Map<Property, List<Lock>> propLockMap = new HashMap<Property, List<Lock>>();
    private Map<Lock, List<LockActivity>> lockLockActivityMap =
            new HashMap<Lock, List<LockActivity>>();

    // Temporarily store the new object to be added
    private Lock newLock = new Lock();
    private LockActivity newLockActivity = new LockActivity();
    private int hostId;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Information.user = user;
    }

    public Map<Property, List<Lock>> getPropLockMap() {
        return propLockMap;
    }

    public void setPropLockMap(Map<Property, List<Lock>> propLockMap) {
        this.propLockMap = propLockMap;
    }

    public Map<Lock, List<LockActivity>> getLockLockActivityMap() {
        return lockLockActivityMap;
    }

    public void setLockLockActivityMap(Map<Lock, List<LockActivity>> lockLockActivityMap) {
        this.lockLockActivityMap = lockLockActivityMap;
    }

    public Lock getNewLock() {
        return newLock;
    }

    public void setNewLock(Lock newLock) {
        this.newLock = newLock;
    }

    public LockActivity getNewLockActivity() {
        return newLockActivity;
    }

    public void setNewLockActivity(LockActivity newLockActivity) {
        this.newLockActivity = newLockActivity;
    }

    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }
}