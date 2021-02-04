/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.du.sirigaddepriyanka.model.business.manager;

import edu.du.sirigaddepriyanka.model.business.factory.PersistFactory;
import edu.du.sirigaddepriyanka.model.business.factory.ServiceFactory;
import edu.du.sirigaddepriyanka.model.services.IServices;

/**
 *
 * @author priyankasirigadde
 */
public class Manager {

    private final ServiceFactory serviceFactory = new ServiceFactory();
    private final PersistFactory persistFactory = new PersistFactory();

    /**
     *gets the appropriate service
     * @param name
     * @return IServices
     * @throws Exception
     */
    protected IServices getService(String name) throws Exception {
        IServices serviceName = serviceFactory.getService(name);
        return serviceName;
    }

    /**
     *gets the appropriate persistent service
     * @param name
     * @return IServices
     * @throws Exception
     */
    protected IServices getPersistService(String name) throws Exception {
        IServices serviceName = persistFactory.getService(name);
        return serviceName;
    }
}
