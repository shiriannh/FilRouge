package chateaudecartes.ejb.facades;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import chateaudecartes.ejb.entities.Editeur;
import chateaudecartes.ejb.entities.Jeu;
import net.entetrs.commons.jpa.AbstractDaoEntrepriseEdition;

@Stateless
// ici avec l'extend on récupere tout pour un dao, et on le type en ajoutant
// voiture dans le generics.
public class FacadeEditeur extends AbstractDaoEntrepriseEdition<Editeur> {

	// l'annotation permet via l'injection de dependance de recuperer un
	// contexte via glassfish. Se fait ici car la classe est géré par le serveur
	// d'appli
	@PersistenceContext
	EntityManager em;

	@Override
	public EntityManager getEntityManager() {

		return em;
	}

	public List<Jeu> listeJeuxParEditeur(Editeur e) {
		
		
		TypedQuery<Jeu> jpqlQuery = em.createQuery("Select j from Jeu j where j.editeur = :editeur",Jeu.class);
		jpqlQuery.setParameter("editeur", e);
		List<Jeu> results = jpqlQuery.getResultList();
		
		
		return results;
	}

}
