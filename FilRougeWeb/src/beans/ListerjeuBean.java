package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entities.Jeu;
import facades.JeuFacade;
import lombok.Getter;

@ViewScoped
@Named
public class ListerjeuBean implements Serializable {

	@Inject
	private JeuFacade	facade;

	@Getter
	private List<Jeu>	liste;

	@PostConstruct
	public void init() {
		liste = facade.readAll();
	}

	public void supprimer(Jeu j) {
		facade.delete(j);
		this.init();
	}

}
