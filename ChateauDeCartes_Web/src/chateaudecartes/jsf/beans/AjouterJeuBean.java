package chateaudecartes.jsf.beans;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import chateaudecartes.ejb.entities.Editeur;
import chateaudecartes.ejb.entities.JeuDeRole;
import chateaudecartes.ejb.entities.JeuDeSociete;
import chateaudecartes.ejb.entities.Type;
import chateaudecartes.ejb.facades.FacadeEditeur;
import chateaudecartes.ejb.facades.FacadeJeuDeRole;
import chateaudecartes.ejb.facades.FacadeJeuDeSociete;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.extern.apachecommons.CommonsLog;
import net.entetrs.commons.jsf.JsfUtils;

@Named
@ViewScoped
@FieldDefaults(level = AccessLevel.PRIVATE)
@CommonsLog
public class AjouterJeuBean implements Serializable {
	private static final long	serialVersionUID	= 1L;

	@Inject
	FacadeEditeur				facadeEditeur;

	@Inject
	FacadeJeuDeSociete			facadeJeuDeSociete;

	@Inject
	FacadeJeuDeRole				facadeJeuRole;

	@Getter
	@Setter
	List<TypeJeu>				listeTypeJeu;

	@Getter
	@Setter
	TypeJeu						typeJeu;

	@Getter
	@Setter
	Boolean						afficherJeuRole;

	@Getter
	@Setter
	String						nomJeu;

	@Getter
	@Setter
	Date						dateSortie;

	@Getter
	@Setter
	String						description;

	@Getter
	@Setter
	String						apercu;

	@Getter
	@Setter
	List<Editeur>				listeEditeur;

	@Getter
	@Setter
	Editeur						editeur;

	@Getter
	@Setter
	Boolean						afficherJeuSociete;

	@Getter
	@Setter
	JeuDeRole					jeuDeRole;

	@Getter
	@Setter
	JeuDeSociete				jeuDeSociete;

	@Getter
	@Setter
	List<Type>					listeType;

	@Getter
	@Setter
	Type						type;

	@Getter
	@Setter
	String						systeme;

	@Getter
	@Setter
	int							nbrJoueurs;

	@Getter
	@Setter
	boolean						typeJeuCartePlateau;

	@PostConstruct
	private void init() {
		listeTypeJeu = new LinkedList<>();
		listeType = Arrays.asList(Type.values());
		peupler(listeTypeJeu);
		afficherJeuRole = Boolean.FALSE;
		afficherJeuSociete = Boolean.FALSE;
		chargerListEditeur();
	}

	private List<TypeJeu> peupler(List<TypeJeu> list) {
		list.add(TypeJeu.JEU_DE_ROLE);
		list.add(TypeJeu.JEU_SOCIETE);
		return list;
	}

	private void chargerListEditeur() {
		listeEditeur = facadeEditeur.readAll();
	}

	public void afficherTypeJeu(TypeJeu t) {
		log.info("listener");
		if (t.equals(TypeJeu.JEU_DE_ROLE)) {
			jeuDeRole = facadeJeuRole.newInstance();
			afficherJeuSociete = Boolean.FALSE;
			afficherJeuRole = Boolean.TRUE;
			JsfUtils.sendMessage("On est sur un jeu de role avec l'id %s", jeuDeRole.getId());
			log.info("Passage JdR");
		} else {
			jeuDeSociete = facadeJeuDeSociete.newInstance();
			afficherJeuRole = Boolean.FALSE;
			afficherJeuSociete = Boolean.TRUE;
			JsfUtils.sendMessage("On est sur un jeu de société avec l'id %s", jeuDeSociete.getId());
			log.info("Passage JdS");
		}
	}

	public void creerJeu() {

		if (typeJeu.equals(TypeJeu.JEU_DE_ROLE)) {
			jeuDeRole = facadeJeuRole.newInstance();
			jeuDeRole.setEditeur(editeur);
			jeuDeRole.setDateSortie(dateSortie);
			jeuDeRole.setNom(nomJeu);
			jeuDeRole.setDescription(description);
			jeuDeRole.setSysteme(systeme);
			jeuDeRole.setType(type);
			facadeJeuRole.create(jeuDeRole);
			JsfUtils.sendMessage("Jeu %s ajouté", jeuDeRole.getNom());
		} else {
			jeuDeSociete = facadeJeuDeSociete.newInstance();
			jeuDeSociete.setEditeur(editeur);
			jeuDeSociete.setDateSortie(dateSortie);
			jeuDeSociete.setNom(nomJeu);
			jeuDeSociete.setDescription(description);
			jeuDeSociete.setNbrDeJoueurs(nbrJoueurs);
			jeuDeSociete.setPlateauCarte(typeJeuCartePlateau);
			facadeJeuDeSociete.create(jeuDeSociete);
			JsfUtils.sendMessage("Jeu %s ajouté", jeuDeSociete.getNom());
		}
	}

}
