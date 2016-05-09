package beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entities.Genre;
import entities.Jeu;
import entities.Support;
import facades.JeuFacade;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class CreerJeuBean implements Serializable {

	@Inject
	JeuFacade				facadeJeu;

	@Getter
	@Setter
	private Jeu				jeu;

	@Getter
	@Setter
	private Date			date;
	@Getter
	@Setter
	private List<String>	images;

	@PostConstruct
	public void init() {
		jeu = facadeJeu.newInstance();
		images = new ArrayList<String>();
		for (int i = 1; i <= 12; i++) {
			images.add("jeu" + i + ".jpg");
		}

	}

	public Genre[] getGenres() {
		return facadeJeu.getGenres();
	}

	public Support[] getSupports() {
		return facadeJeu.getSupports();
	}

	public void creerJeu() {
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		jeu.setDateSortie(localDate);
		facadeJeu.create(jeu);

	}

}
