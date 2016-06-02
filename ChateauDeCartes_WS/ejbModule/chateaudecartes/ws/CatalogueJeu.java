package chateaudecartes.ws;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import chateaudecartes.ejb.entities.Jeu;
import chateaudecartes.ejb.facades.FacadeJeu;

@WebService(serviceName="ChateauDeCarteServices", name="GameCatalog")
@Stateless
public class CatalogueJeu {
	
	@Inject
	FacadeJeu facadeJeu;
	
	@WebMethod(operationName="gameList")
	public List<Jeu> listJeu()
	{
		return facadeJeu.readAll();
	}

}
