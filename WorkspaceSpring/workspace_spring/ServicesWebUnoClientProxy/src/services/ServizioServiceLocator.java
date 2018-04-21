/**
 * ServizioServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package services;

public class ServizioServiceLocator extends org.apache.axis.client.Service implements services.ServizioService {

    public ServizioServiceLocator() {
    }


    public ServizioServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServizioServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Servizio
    private java.lang.String Servizio_address = "http://localhost:9090/ServicesWebUno/services/Servizio";

    public java.lang.String getServizioAddress() {
        return Servizio_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServizioWSDDServiceName = "Servizio";

    public java.lang.String getServizioWSDDServiceName() {
        return ServizioWSDDServiceName;
    }

    public void setServizioWSDDServiceName(java.lang.String name) {
        ServizioWSDDServiceName = name;
    }

    public services.Servizio getServizio() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Servizio_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServizio(endpoint);
    }

    public services.Servizio getServizio(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            services.ServizioSoapBindingStub _stub = new services.ServizioSoapBindingStub(portAddress, this);
            _stub.setPortName(getServizioWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServizioEndpointAddress(java.lang.String address) {
        Servizio_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (services.Servizio.class.isAssignableFrom(serviceEndpointInterface)) {
                services.ServizioSoapBindingStub _stub = new services.ServizioSoapBindingStub(new java.net.URL(Servizio_address), this);
                _stub.setPortName(getServizioWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Servizio".equals(inputPortName)) {
            return getServizio();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://services", "ServizioService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://services", "Servizio"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Servizio".equals(portName)) {
            setServizioEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
