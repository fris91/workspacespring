package services;

public class ServizioProxy implements services.Servizio {
  private String _endpoint = null;
  private services.Servizio servizio = null;
  
  public ServizioProxy() {
    _initServizioProxy();
  }
  
  public ServizioProxy(String endpoint) {
    _endpoint = endpoint;
    _initServizioProxy();
  }
  
  private void _initServizioProxy() {
    try {
      servizio = (new services.ServizioServiceLocator()).getServizio();
      if (servizio != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servizio)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servizio)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servizio != null)
      ((javax.xml.rpc.Stub)servizio)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public services.Servizio getServizio() {
    if (servizio == null)
      _initServizioProxy();
    return servizio;
  }
  
  public int somma(int a, int b) throws java.rmi.RemoteException{
    if (servizio == null)
      _initServizioProxy();
    return servizio.somma(a, b);
  }
  
  public int sottrazione(int a, int b) throws java.rmi.RemoteException{
    if (servizio == null)
      _initServizioProxy();
    return servizio.sottrazione(a, b);
  }
  
  
}