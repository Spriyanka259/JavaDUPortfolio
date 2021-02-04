/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.du.sirigaddepriyanka.model.business.manager.ownermanager;

import edu.du.sirigaddepriyanka.model.business.manager.Manager;
import edu.du.sirigaddepriyanka.model.domain.Owner;
import edu.du.sirigaddepriyanka.model.services.ownerservice.IOwnerService;
import java.util.ArrayList;

/**
 *
 * @author priyankasirigadde
 */
public class OwnerManager extends Manager {

    /**
     *adds the element
     * @param owner
     * @return Boolean
     * @throws Exception
     */
    public boolean add(Owner owner) throws Exception {
        boolean value = false;
        try {
            IOwnerService ownerService = (IOwnerService) getService(IOwnerService.NAME);
            value = ownerService.add(owner);
        } catch (Exception e) {
            throw e;
        }
        return value;
    }

    /**
     *removes the element
     * @param owner
     * @return Boolean
     * @throws Exception
     */
    public boolean remove(Owner owner) throws Exception {
        boolean value = false;
        try {
            IOwnerService ownerService = (IOwnerService) getService(IOwnerService.NAME);
            value = ownerService.remove(owner);
        } catch (Exception e) {
            throw e;
        }
        return value;
    }

    /**
     *removes the element
     * @param ownerID
     * @return Boolean
     * @throws Exception
     */
    public boolean remove(String ownerID) throws Exception {
        boolean value = false;
        try {
            IOwnerService ownerService = (IOwnerService) getService(IOwnerService.NAME);
            value = ownerService.remove(ownerID);
        } catch (Exception e) {
            throw e;
        }
        return value;
    }

    /**
     *finds the element
     * @param ownerID
     * @return Owner
     * @throws Exception
     */
    public Owner find(String ownerID) throws Exception {
        Owner owner = new Owner();
        try {
            IOwnerService ownerService = (IOwnerService) getService(IOwnerService.NAME);
            owner = ownerService.find(ownerID);
        } catch (Exception e) {
            throw e;
        }
        return owner;
    }

    /**
     *checks if the element is unique
     * @param ownerID
     * @return Boolean
     * @throws Exception
     */
    public boolean isUnique(String ownerID) throws Exception {
        boolean value = false;
        try {
            IOwnerService ownerService = (IOwnerService) getService(IOwnerService.NAME);
            value = ownerService.isUnique(ownerID);
        } catch (Exception e) {
            throw e;
        }
        return value;
    }

    /**
     *checks if the element is unique
     * @param owner
     * @return Boolean
     * @throws Exception
     */
    public boolean isUnique(Owner owner) throws Exception {
        boolean value = false;
        try {
            IOwnerService ownerService = (IOwnerService) getService(IOwnerService.NAME);
            value = ownerService.isUnique(owner);
        } catch (Exception e) {
            throw e;
        }
        return value;
    }

    /**
     *Prints all the elements
     * @throws Exception
     */
    public void dump() throws Exception {
        boolean value = false;
        try {
            IOwnerService ownerService = (IOwnerService) getService(IOwnerService.NAME);
            ownerService.dump();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     *gets all the elements
     * @return ArrayList
     * @throws Exception
     */
    public ArrayList<Owner> getArrayList() throws Exception {
        ArrayList<Owner> value = new ArrayList<>();
        try {
            IOwnerService ownerService = (IOwnerService) getService(IOwnerService.NAME);
            value = ownerService.getOwnerArrayList();
        } catch (Exception e) {
            throw e;
        }
        return value;
    }
}
