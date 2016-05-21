package chateaudecartes.jsf.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import chateaudecartes.ejb.entities.Jeu;
import chateaudecartes.ejb.facades.FacadeJeu;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class ListerJeuxGaleriaBean implements Serializable {

	private static final long	serialVersionUID	= 1L;

	@Inject
	FacadeJeu					facade;

	@Getter
	@Setter
	List<Jeu>					listeJeu;

	@PostConstruct
	public void init() {
		listeJeu = facade.readAll();
	}

}
