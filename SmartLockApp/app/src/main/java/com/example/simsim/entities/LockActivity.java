package com.example.simsim.entities;

public class LockActivity {

    private int userID;
    private int lockID;
    private String accessStartTime;
    private String accessEndTime;
    private String requestAccessTimestamp;
    private boolean requestStatus;
    private int alert;
    /**
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }
    /**
     * @param userID the userID to set
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }
    /**
     * @return the lockID
     */
    public int getLockID() {
        return lockID;
    }
    /**
     * @param lockID the lockID to set
     */
    public void setLockID(int lockID) {
        this.lockID = lockID;
    }
    /**
     * @return the accessStartTime
     */
    public String getAccessStartTime() {
        return accessStartTime;
    }
    /**
     * @param accessStartTime the accessStartTime to set
     */
    public void setAccessStartTime(String accessStartTime) {
        this.accessStartTime = accessStartTime;
    }
    /**
     * @return the accessEndTime
     */
    public String getAccessEndTime() {
        return accessEndTime;
    }
    /**
     * @param accessEndTime the accessEndTime to set
     */
    public void setAccessEndTime(String accessEndTime) {
        this.accessEndTime = accessEndTime;
    }
    /**
     * @return the requestAccessTimestamp
     */
    public String getRequestAccessTimestamp() {
        return requestAccessTimestamp;
    }
    /**
     * @param requestAccessTimestamp the requestAccessTimestamp to set
     */
    public void setRequestAccessTimestamp(String requestAccessTimestamp) {
        this.requestAccessTimestamp = requestAccessTimestamp;
    }
    /**
     * @return the requestStatus
     */
    public boolean isRequestStatus() {
        return requestStatus;
    }
    /**
     * @param requestStatus the requestStatus to set
     */
    public void setRequestStatus(boolean requestStatus) {
        this.requestStatus = requestStatus;
    }
    /**
     * @return the alert
     */
    public int getAlert() {
        return alert;
    }
    /**
     * @param alert the alert to set
     */
    public void setAlert(int alert) {
        this.alert = alert;
    }

}
