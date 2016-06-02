/**
 * ChateauDeCarteServices.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package chateaudecartes.ws;

public interface ChateauDeCarteServices extends javax.xml.rpc.Service {
    public java.lang.String getGameCatalogPortAddress();

    public chateaudecartes.ws.GameCatalog getGameCatalogPort() throws javax.xml.rpc.ServiceException;

    public chateaudecartes.ws.GameCatalog getGameCatalogPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
