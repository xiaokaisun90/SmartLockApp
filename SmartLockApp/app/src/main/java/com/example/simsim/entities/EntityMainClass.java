package com.example.simsim.entities;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by xiaokaisun on 7/21/15.
 */
public class EntityMainClass {
    private static User user;
    private static Map<Properties, Locks> propLockMap;
    private static Map<Locks, LockActivity> locksLockActivityMap = new LinkedHashMap<Locks, LockActivity>();

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        EntityMainClass.user = user;
    }

    public static Map<Properties, Locks> getPropLockMap() {
        return propLockMap;
    }

    public static void setPropLockMap(Map<Properties, Locks> propLockMap) {
        EntityMainClass.propLockMap = propLockMap;
    }

    public static Map<Locks, LockActivity> getLocksLockActivityMap() {
        return locksLockActivityMap;
    }

    public static void setLocksLockActivityMap(Map<Locks, LockActivity> locksLockActivityMap) {
        EntityMainClass.locksLockActivityMap = locksLockActivityMap;
    }
}
