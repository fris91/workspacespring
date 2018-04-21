/**
 * ServizioService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package services;

public interface ServizioService extends javax.xml.rpc.Service {
    public java.lang.String getServizioAddress();

    public services.Servizio getServizio() throws javax.xml.rpc.ServiceException;

    public services.Servizio getServizio(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
