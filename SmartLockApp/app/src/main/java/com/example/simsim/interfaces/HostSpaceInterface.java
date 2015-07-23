package com.example.simsim.interfaces;

import com.example.simsim.entities.Lock;
import com.example.simsim.entities.Property;

import java.util.List;

/**
 * Created by Qiuge on 2015/7/23.
 */
public interface HostSpaceInterface {

    List<Property> getPropertyList();
    void insertProperty(Property property);
    void updateProperty(Property property);
    void deleteProperty(Property property);
    List<Lock> getLockList(Property property);
    void insertLock(Property property, Lock lock);
    void updateLock(Property property, Lock lock);
    void deleteLock(Property property, Lock lock);

}
