package com.example.simsim.entities;


public class LockActivity {

    private int lockActicityId;
    private int hostId;
    private int guestId;
    private int lockId;
    private String accessStartTime;
    private String accessEndTime;
    private String requestAccessTimestamp;
    private boolean requestStatus;
    private int alert;

    public int getLockActicityId() {
        return lockActicityId;
    }

    public void setLockActicityId(int lockActicityId) {
        this.lockActicityId = lockActicityId;
    }

    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public int getLockId() {
        return lockId;
    }

    public void setLockId(int lockId) {
        this.lockId = lockId;
    }

    public String getAccessStartTime() {
        return accessStartTime;
    }

    public void setAccessStartTime(String accessStartTime) {
        this.accessStartTime = accessStartTime;
    }

    public String getAccessEndTime() {
        return accessEndTime;
    }

    public void setAccessEndTime(String accessEndTime) {
        this.accessEndTime = accessEndTime;
    }

    public String getRequestAccessTimestamp() {
        return requestAccessTimestamp;
    }

    public void setRequestAccessTimestamp(String requestAccessTimestamp) {
        this.requestAccessTimestamp = requestAccessTimestamp;
    }

    public boolean isRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(boolean requestStatus) {
        this.requestStatus = requestStatus;
    }

    public int getAlert() {
        return alert;
    }

    public void setAlert(int alert) {
        this.alert = alert;
    }
}
