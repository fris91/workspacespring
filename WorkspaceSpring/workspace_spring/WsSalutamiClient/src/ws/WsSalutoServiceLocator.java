/**
 * WsSalutoServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws;

public class WsSalutoServiceLocator extends org.apache.axis.client.Service implements ws.WsSalutoService {

    public WsSalutoServiceLocator() {
    }


    public WsSalutoServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WsSalutoServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WsSaluto
    private java.lang.String WsSaluto_address = "http://localhost:8080/WsSoapSalutoDynamic/services/WsSaluto";

    public java.lang.String getWsSalutoAddress() {
        return WsSaluto_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WsSalutoWSDDServiceName = "WsSaluto";

    public java.lang.String getWsSalutoWSDDServiceName() {
        return WsSalutoWSDDServiceName;
    }

    public void setWsSalutoWSDDServiceName(java.lang.String name) {
        WsSalutoWSDDServiceName = name;
    }

    public ws.WsSaluto getWsSaluto() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WsSaluto_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWsSaluto(endpoint);
    }

    public ws.WsSaluto getWsSaluto(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ws.WsSalutoSoapBindingStub _stub = new ws.WsSalutoSoapBindingStub(portAddress, this);
            _stub.setPortName(getWsSalutoWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWsSalutoEndpointAddress(java.lang.String address) {
        WsSaluto_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ws.WsSaluto.class.isAssignableFrom(serviceEndpointInterface)) {
                ws.WsSalutoSoapBindingStub _stub = new ws.WsSalutoSoapBindingStub(new java.net.URL(WsSaluto_address), this);
                _stub.setPortName(getWsSalutoWSDDServiceName());
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
        if ("WsSaluto".equals(inputPortName)) {
            return getWsSaluto();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws", "WsSalutoService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws", "WsSaluto"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WsSaluto".equals(portName)) {
            setWsSalutoEndpointAddress(address);
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
