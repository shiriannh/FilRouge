package chateaudecartes.jsf.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import chateaudecartes.ejb.entities.JeuDeRole;
import chateaudecartes.ejb.entities.JeuDeSociete;
import chateaudecartes.ejb.facades.FacadeJeuDeRole;
import chateaudecartes.ejb.facades.FacadeJeuDeSociete;
import lombok.Getter;
import lombok.Setter;
import net.entetrs.commons.jsf.JsfUtils;

@Named
@ViewScoped
public class ModifierJeux implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	@Inject
	FacadeJeuDeRole				facadeJdr;

	@Inject
	FacadeJeuDeSociete			facadeJds;

	@Getter
	@Setter
	private JeuDeRole			jdr;
	@Getter
	@Setter
	private JeuDeSociete		jds;

	@PostConstruct
	public void init() {
		jdr = (JeuDeRole) JsfUtils.getFromFlashScope("jdr");
		jds = (JeuDeSociete) JsfUtils.getFromFlashScope("jds");
	}

	public <T> void modifierJeu(T type) {

		if (type instanceof JeuDeRole) {
			facadeJdr.update(jdr);
			JsfUtils.sendMessage("Jeu de rôle modifé !");
		}
		if (type instanceof JeuDeSociete) {
			facadeJds.update(jds);
			JsfUtils.sendMessage("Jeu de société modifé !");
		}

	}

}
