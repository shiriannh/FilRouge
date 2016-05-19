package chateaudecartes.jsf.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import chateaudecartes.ejb.entities.Editeur;
import chateaudecartes.ejb.entities.JeuDeRole;
import chateaudecartes.ejb.facades.FacadeEditeur;
import chateaudecartes.ejb.facades.FacadeJeuDeRole;
import chateaudecartes.ejb.facades.FacadeJeuDeSociete;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.extern.apachecommons.CommonsLog;

@Named
@ViewScoped
@FieldDefaults(level=AccessLevel.PRIVATE)
@CommonsLog
public class AjouterJeuBean implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Inject
	FacadeEditeur facadeEditeur;
	
	@Inject
	FacadeJeuDeSociete facadeJeuDeSociete;

	@Inject
	FacadeJeuDeRole facadeJeuRole;

	@Getter @Setter
	List<TypeJeu> listeTypeJeu;

	@Getter @Setter
	TypeJeu typeJeu;

	@Getter @Setter
	Boolean afficherJeuRole;
	
	@Getter @Setter
	String nomJeu;
	
	@Getter @Setter
	Date dateSortie;
	
	@Getter @Setter
	String description;
	
	@Getter @Setter
	String apercu;
	
	@Getter @Setter
	List<Editeur> listeEditeur;
	
	@Getter @Setter
	Editeur editeur;

	@Getter @Setter
	Boolean afficherJeuSociete;

	@PostConstruct
	private void init() {
		listeTypeJeu = new LinkedList<>();
		peupler(listeTypeJeu);
		afficherJeuRole = Boolean.FALSE;
		afficherJeuSociete = Boolean.FALSE;
		chargerListEditeur();
	}

	private List<TypeJeu> peupler(List<TypeJeu> list)
	{
		list.add(TypeJeu.JEU_DE_ROLE);
		list.add(TypeJeu.JEU_SOCIETE);
		return list;
	}
	
	private void chargerListEditeur()
	{
		listeEditeur = facadeEditeur.readAll();
	}

	public void afficherTypeJeu(TypeJeu t)
	{
		log.info("listener");
		if (t.equals(TypeJeu.JEU_DE_ROLE)) {
			afficherJeuSociete = Boolean.FALSE;
			afficherJeuRole = Boolean.TRUE;
			log.info("Passage JdR");
		}else
		{
			afficherJeuRole = Boolean.FALSE;
			afficherJeuSociete = Boolean.TRUE;
			log.info("Passage JdS");
		}
	}
	
	public void creerJeu()
	{
		if (typeJeu.equals(TypeJeu.JEU_DE_ROLE)) {
			JeuDeRole jdr = facadeJeuRole.newInstance();
			jdr.setEditeur(editeur);
			jdr.setDateSortie(dateSortie);
			jdr.setNom(nomJeu);
			jdr.setDescription(description);
			
			facadeJeuRole.create(jdr);
		}
	}

}
