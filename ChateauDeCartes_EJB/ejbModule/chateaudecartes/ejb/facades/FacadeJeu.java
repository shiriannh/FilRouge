package chateaudecartes.ejb.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import chateaudecartes.ejb.entities.Jeu;
import net.entetrs.commons.jpa.AbstractDaoEntrepriseEdition;

@Stateless
// ici avec l'extend on récupere tout pour un dao, et on le type en ajoutant
// voiture dans le generics.
public class FacadeJeu extends AbstractDaoEntrepriseEdition<Jeu> {

	// l'annotation permet via l'injection de dependance de recuperer un
	// contexte via glassfish. Se fait ici car la classe est géré par le serveur
	// d'appli
	@PersistenceContext
	EntityManager em;

	@Override
	public EntityManager getEntityManager() {

		return em;
	}

}
