package chateaudecartes.ws;

public class GameCatalogProxy implements chateaudecartes.ws.GameCatalog {
  private String _endpoint = null;
  private chateaudecartes.ws.GameCatalog gameCatalog = null;
  
  public GameCatalogProxy() {
    _initGameCatalogProxy();
  }
  
  public GameCatalogProxy(String endpoint) {
    _endpoint = endpoint;
    _initGameCatalogProxy();
  }
  
  private void _initGameCatalogProxy() {
    try {
      gameCatalog = (new chateaudecartes.ws.ChateauDeCarteServicesLocator()).getGameCatalogPort();
      if (gameCatalog != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)gameCatalog)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)gameCatalog)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (gameCatalog != null)
      ((javax.xml.rpc.Stub)gameCatalog)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public chateaudecartes.ws.GameCatalog getGameCatalog() {
    if (gameCatalog == null)
      _initGameCatalogProxy();
    return gameCatalog;
  }
  
  public chateaudecartes.ws.Jeu[] gameList() throws java.rmi.RemoteException{
    if (gameCatalog == null)
      _initGameCatalogProxy();
    return gameCatalog.gameList();
  }
  
  
}