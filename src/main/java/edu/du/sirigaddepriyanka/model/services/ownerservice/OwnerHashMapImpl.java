/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.du.sirigaddepriyanka.model.services.ownerservice;

import edu.du.sirigaddepriyanka.model.domain.Owner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author priyankasirigadde
 */
public class OwnerHashMapImpl implements IOwnerService {

    private static Map<String, Owner> ownerHashMap = new HashMap<>();

    /**
     *
     */
    public OwnerHashMapImpl() {
    }

    /**
     *
     * @return 
     */
    public static Map<String, Owner> getOwnerHashMap() {
        return ownerHashMap;
    }

    /**
     *
     * @param aOwnerHashMap
     */
    public static void setOwnerHashMap(Map<String, Owner> aOwnerHashMap) {
        ownerHashMap = aOwnerHashMap;
    }

    /**
     *adds the element to the Array List
     * @param owner
     * @return 
     */
    @Override
    public boolean add(Owner owner) {
        boolean value = false;
        Owner addedOwner = ownerHashMap.put(owner.getOwnerID(), owner);
        if (addedOwner == null) {
            value = true;
        }
        return value;
    }

    /**
     *removes the element from the Array List
     * @param owner
     * @return 
     */
    @Override
    public boolean remove(Owner owner) {
        boolean value = false;
        Iterator<Owner> itr = ownerHashMap.values().iterator();
        while (itr.hasNext()) {
            if ((owner.getOwnerID()).equals(itr.next().getOwnerID())) {
                itr.remove();
                value = true;
            }
        }
        return value;
    }

    /**
     *removes the element from the Array List
     * @param ownerID
     * @return 
     * @throws java.lang.Exception
     */
    @Override
    public boolean remove(String ownerID) throws Exception {
        boolean value = false;
        Iterator<String> itr = ownerHashMap.keySet().iterator();
        while (itr.hasNext()) {
            if (itr.next().equals(ownerID)) {
                itr.remove();
                value = true;
            }
        }
        return value;
    }

    /**
     *finds the element from the Array List
     * @param ownerID
     * @return 
     */
    @Override
    public Owner find(String ownerID) {
        return ownerHashMap.get(ownerID);
    }

    /**
     *checks if the element is unique
     * @param ownerID
     * @return 
     */
    @Override
    public boolean isUnique(String ownerID) {
        boolean value = false;
        Owner foundOwner = ownerHashMap.get(ownerID);
        if (foundOwner == null) {
            value = true;
        }
        return value;
    }

    /**
     *checks if the element is unique
     * @param owner
     * @return 
     */
    @Override
    public boolean isUnique(Owner owner) {
        boolean value = false;
        Owner foundOwner = ownerHashMap.get(owner.getOwnerID());
        if (foundOwner == null) {
            value = true;
        }
        return value;
    }

    /**
     *prints all the elements of the Array List
     */
    @Override
    public void dump() {
        if (!ownerHashMap.isEmpty()) {
            Iterator<Owner> itr = ownerHashMap.values().iterator();
            while (itr.hasNext()) {
                System.out.println(itr.next().toString());
            }
        }
    }

    /**
     *converts all the elements of the HashMap into Array List
     * @return 
     */
    @Override
    public ArrayList<Owner> getOwnerArrayList() {
        Collection<Owner> values = ownerHashMap.values();
        ArrayList<Owner> ownerArrayList = new ArrayList<>(values);
        return ownerArrayList;
    }

}
