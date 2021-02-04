/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.du.sirigaddepriyanka.model.business.factory;

import edu.du.sirigaddepriyanka.model.services.IServices;
import java.io.IOException;

/**
 *
 * @author priyankasirigadde
 */
public class ServiceFactory {

    public ServiceFactory() {
    }

    private static ServiceFactory serviceFactory = new ServiceFactory();

    /**
     * This is using the Java singleton pattern, where only one instance of the
     * ServiceFactory will exist
     *
     * @return ServiceFactory
     */
    public static ServiceFactory getInstance() {
        return serviceFactory;
    }

    /**
     * This is where the service name will be dynamically loaded into a class
     *
     * @param serviceName
     * @return IServices
     * @throws Exception
     */
    public IServices getService(String serviceName) throws Exception {
        Class<?> c = null;
        try {
            String className = getImplName(serviceName);
            c = Class.forName(className);

        } catch (Exception e1) {
            throw e1;
        }
        IServices instanceName = (IServices) c.getConstructor().newInstance();

        return instanceName;
    }

    /**
     * The service properties file is where the classes are associated with the
     * service names. Use of the Java Properties API makes life a bit easier
     * here - provide the service name and the class is returned.
     *
     * @param serviceName
     * @return String
     * @throws Exception
     */
    private String getImplName(String serviceName) throws Exception {
        String retName = null;
        try {
            java.util.Properties props = new java.util.Properties();

            String propFile = "serviceproperties.txt";
            try (java.io.FileInputStream fis = new java.io.FileInputStream(propFile)) {
                props.load(fis);
            }
            String implName = props.getProperty(serviceName);
            retName = implName;
        } catch (IOException e1) {
            System.out.println("throw property exception" + e1.toString());
            throw new Exception("Service properties file not found");
        }

        return retName;
    }
}
