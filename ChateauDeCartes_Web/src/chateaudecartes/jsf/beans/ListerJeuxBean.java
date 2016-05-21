package chateaudecartes.jsf.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import chateaudecartes.ejb.entities.Editeur;
import chateaudecartes.ejb.entities.Jeu;
import chateaudecartes.ejb.entities.JeuDeRole;
import chateaudecartes.ejb.entities.JeuDeSociete;
import chateaudecartes.ejb.facades.FacadeEditeur;
import lombok.Getter;
import lombok.Setter;
import net.entetrs.commons.jsf.JsfUtils;

@Named
@ViewScoped
public class ListerJeuxBean implements Serializable {

	private static final long	serialVersionUID	= 1L;

	@Inject
	FacadeEditeur				facadeEditeur;

	@Getter
	@Setter
	List<Editeur>				listeEditeur;

	@Getter
	@Setter
	List<Jeu>					listeJeux;

	@Getter
	@Setter
	Editeur						editeurSelect;

	@PostConstruct
	private void init() {
		chargerListeEditeur();

	}

	private void chargerListeEditeur() {
		listeEditeur = facadeEditeur.readAll();

	}

	public void chargerListeJeux() {
		System.out.println(editeurSelect.getNom());
		System.out.println(editeurSelect.getJeux().size());
		System.out.println(editeurSelect.getJeux().isEmpty());
		listeJeux = facadeEditeur.listeJeuxParEditeur(editeurSelect);

	}

	/**
	 * Obtenir l'image correspondant à la marque
	 * 
	 * @param e
	 *            l'Editeur du Jeu
	 * @return le nom complet de l'image.
	 */
	public String image(Editeur e) {
		return e.getLogo();
	}

	public void selectionnerJeu(Object jeu) {
		if (jeu instanceof JeuDeRole) {
			JsfUtils.putInFlashScope("jdr", jeu);
		}
		if (jeu instanceof JeuDeSociete) {
			JsfUtils.putInFlashScope("jds", jeu);
		}

	}

}
