package ws;

public class WsSalutoProxy implements ws.WsSaluto {
  private String _endpoint = null;
  private ws.WsSaluto wsSaluto = null;
  
  public WsSalutoProxy() {
    _initWsSalutoProxy();
  }
  
  public WsSalutoProxy(String endpoint) {
    _endpoint = endpoint;
    _initWsSalutoProxy();
  }
  
  private void _initWsSalutoProxy() {
    try {
      wsSaluto = (new ws.WsSalutoServiceLocator()).getWsSaluto();
      if (wsSaluto != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wsSaluto)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wsSaluto)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wsSaluto != null)
      ((javax.xml.rpc.Stub)wsSaluto)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ws.WsSaluto getWsSaluto() {
    if (wsSaluto == null)
      _initWsSalutoProxy();
    return wsSaluto;
  }
  
  public java.lang.String saluto(int tipoSaluto) throws java.rmi.RemoteException{
    if (wsSaluto == null)
      _initWsSalutoProxy();
    return wsSaluto.saluto(tipoSaluto);
  }
  
  
}