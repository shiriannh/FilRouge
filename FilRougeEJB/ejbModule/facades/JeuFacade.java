package facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Genre;
import entities.Jeu;
import entities.Support;
import net.entetrs.commons.jpa.AbstractDaoEntrepriseEdition;

@Stateless
public class JeuFacade extends AbstractDaoEntrepriseEdition<Jeu> {

	@PersistenceContext
	EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public Genre[] getGenres() {
		return Genre.values();
	}

	public Support[] getSupports() {
		return Support.values();
	}

}
