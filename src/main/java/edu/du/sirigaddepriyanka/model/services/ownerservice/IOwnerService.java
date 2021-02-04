/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.du.sirigaddepriyanka.model.services.ownerservice;

import edu.du.sirigaddepriyanka.model.domain.Owner;
import edu.du.sirigaddepriyanka.model.services.IServices;
import java.util.ArrayList;

/**
 *
 * @author priyankasirigadde
 */
public interface IOwnerService extends IServices {

    public final String NAME = "IOwnerService";

    public boolean add(Owner owner);

    public boolean remove(Owner owner);

    public boolean remove(String ownerID) throws Exception;

    public Owner find(String ownerID);

    public boolean isUnique(String ownerID);

    public boolean isUnique(Owner owner);

    public void dump();

    public ArrayList<Owner> getOwnerArrayList();
}
