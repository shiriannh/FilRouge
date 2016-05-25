package chateaudecartes.ejb.facades;

import java.util.LinkedList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import chateaudecartes.ejb.entities.JeuDeSociete;
import chateaudecartes.ejb.entities.Ressource;
import net.entetrs.commons.jpa.AbstractDaoEntrepriseEdition;
import net.entetrs.commons.jpa.EntityFactory;

@Stateless
// ici avec l'extend on récupere tout pour un dao, et on le type en ajoutant
// voiture dans le generics.
public class FacadeJeuDeSociete extends AbstractDaoEntrepriseEdition<JeuDeSociete> {

	// l'annotation permet via l'injection de dependance de recuperer un
	// contexte via glassfish. Se fait ici car la classe est géré par le serveur
	// d'appli
	@PersistenceContext
	EntityManager em;

	@Override
	public EntityManager getEntityManager() {

		return em;
	}

	public void ajouterRessources(String titre, byte[] data, JeuDeSociete jds) {
		JeuDeSociete jdsRelue = this.read(jds.getId());
		if (jdsRelue.getRsc() == null) {
			jdsRelue.setRsc(new LinkedList<Ressource>());
		}

		Ressource r = new EntityFactory<>(Ressource.class).newInstance();

		r.setData(data);
		r.setNom(titre);
		jdsRelue.getRsc().add(r);

	}
}
