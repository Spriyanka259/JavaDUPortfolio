/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.du.sirigaddepriyanka.model.services.ownerservice;

import edu.du.sirigaddepriyanka.model.domain.Owner;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author priyankasirigadde
 */
public class OwnerArrayListImpl implements IOwnerService {

    private static ArrayList<Owner> ownerArrayList = new ArrayList<>();

    /**
     *
     */
    public OwnerArrayListImpl() {
    }

    /**
     *
     * @return
     */
    @Override
    public ArrayList<Owner> getOwnerArrayList() {
        return ownerArrayList;
    }

    /**
     *
     * @param ownerArrayList
     */
    public void setOwnerArrayList(ArrayList<Owner> ownerArrayList) {
        OwnerArrayListImpl.ownerArrayList = ownerArrayList;
    }

    /**
     *adds the element from the Array List
     * @param owner
     * @return
     */
    @Override
    public boolean add(Owner owner) {
        return ownerArrayList.add(owner);
    }

    /**
     *removes the element from the Array List
     * @param owner
     * @return
     */
    @Override
    public boolean remove(Owner owner) {
        return ownerArrayList.remove(owner);
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
        try {
            Iterator<Owner> itr = ownerArrayList.iterator();
            while (itr.hasNext()) {
                Owner owner = itr.next();
                if ((owner.getOwnerID()).equals(ownerID)) {
                    itr.remove();
                    value = true;
                }
            }
        } catch (Exception e) {
            throw new Exception("Exception occurred while removing owner", e);
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
        Owner owner = null;
        for (int i = 0; i < ownerArrayList.size(); i++) {
            if (ownerID.equals(ownerArrayList.get(i).getOwnerID())) {
                owner = ownerArrayList.get(i);
            }
        }
        return owner;
    }

    /**
     *checks if the element is unique
     * @param ownerID
     * @return
     */
    @Override
    public boolean isUnique(String ownerID) {
        boolean value = true;
        for (int i = 0; i < ownerArrayList.size(); i++) {
            if (ownerID.equals(ownerArrayList.get(i).getOwnerID())) {
                value = false;
            }
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
        boolean value = true;
        if (ownerArrayList.contains(owner)) {
            value = false;
        }
        return value;
    }

    /**
     *Prints all the elements of the Array List
     */
    @Override
    public void dump() {
        Iterator<Owner> itr = ownerArrayList.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next().toString());
        }
    }
}
