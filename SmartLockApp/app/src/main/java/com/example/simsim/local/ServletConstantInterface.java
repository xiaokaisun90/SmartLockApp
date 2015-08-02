package com.example.simsim.local;

/**
 * Created by Qiuge on 2015/7/24.
 */
public interface ServletConstantInterface {

    // URL to access
    String URL_AUTHENTICATE = "http://192.168.0.110/SmartLockBackEnd/Authentication";
    String URL_USER_READ = "http://192.168.0.110/SmartLockBackEnd/UserReadServlet";
    String URL_USER_CREATE = "http://192.168.0.110/SmartLockBackEnd/UserCreateServlet";
    String URL_USER_UPDATE = "http://192.168.0.110/SmartLockBackEnd/UserUpdateServlet";
    String URL_USER_DELETE = "";
    String URL_PROPERTY_READ = "";
    String URL_PROPERTY_CREATE = "";
    String URL_PROPERTY_UPDATE = "";
    String URL_PROPERTY_DELETE = "";
    String URL_LOCK_READ = "http://192.168.0.110/SmartLockBackEnd/LockReadServlet";
    String URL_LOCK_CREATE = "";
    String URL_LOCK_UPDATE = "";
    String URL_LOCK_DELETE = "";
    String URL_LOCK_ACTIVITY_READ = "http://192.168.0.110/SmartLockBackEnd/LockActivityReadServlet";
    String URL_LOCK_ACTIVITY_CREATE = "";
    String URL_LOCK_ACTIVITY_UPDATE = "";
    String URL_LOCK_ACTIVITY_DELETE = "";

    // Response content
    String RESPONSE_SUCCESS = "success";
    String RESPONSE_FAILURE = "failure";
}
