package chateaudecartes.ejb.commons;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import chateaudecartes.ejb.entities.Editeur;
import chateaudecartes.ejb.entities.JeuDeRole;
import chateaudecartes.ejb.entities.JeuDeSociete;
import chateaudecartes.ejb.entities.Type;
import chateaudecartes.ejb.facades.FacadeEditeur;
import chateaudecartes.ejb.facades.FacadeJeuDeRole;
import chateaudecartes.ejb.facades.FacadeJeuDeSociete;
import chateaudecartes.ejb.utils.DateConverter;
import chateaudecartes.ejb.utils.propToMap;

@Singleton
@Startup
public class InitSingleton {
	@Inject
	FacadeJeuDeSociete	facadeSociete;
	@Inject
	FacadeJeuDeRole		facadeRole;
	@Inject
	FacadeEditeur		facadeEditeur;

	public void init() {

	}

	@PostConstruct
	public void chargerBDDSociete() {

		try {
			Properties properties = new Properties();
			InputStream input = InitSingleton.class.getResourceAsStream("ChargementBaseSociete.properties");
			properties.load(input);
			Map<String, String> test = propToMap.propertiesToMap(properties);
			input.close();

			for (Entry<String, String> string : test.entrySet()) {

				JeuDeSociete jeu = facadeSociete.newInstance();
				Editeur editeur = facadeEditeur.newInstance();
				String[] valeur = string.getValue().split(";");

				int nbrJoueur = Integer.valueOf(valeur[6]);
				boolean type = Boolean.valueOf(valeur[7]);

				if (!facadeSociete.exists("nom", valeur[0])) {

					jeu.setNom(valeur[0]);
					try {
						jeu.setDateSortie(DateConverter.changeDate(valeur[1]));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					jeu.setDescription(valeur[2]);
					jeu.setApercu(valeur[3]);

					if (facadeEditeur.exists("nom", valeur[5])) {
						editeur = facadeEditeur.searchFirstResult("nom", valeur[5]);
						System.out.println("Existe !");
					} else {
						editeur.setLogo(valeur[4]);
						editeur.setNom(valeur[5]);
						System.out.println("N'existe pas !");
					}

					jeu.setNbrDeJoueurs(nbrJoueur);
					jeu.setPlateauCarte(type);

					jeu.setEditeur(editeur);

					facadeSociete.create(jeu);

					System.out.println("Creation OK");
				} else {
					System.out.println("Le jeu est déjà en base");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Properties properties = new Properties();
			InputStream input = InitSingleton.class.getResourceAsStream("ChargementBaseJdr.properties");
			properties.load(input);
			Map<String, String> test = propToMap.propertiesToMap(properties);
			input.close();

			for (Entry<String, String> string : test.entrySet()) {

				JeuDeRole jeu = facadeRole.newInstance();
				Editeur editeur = facadeEditeur.newInstance();
				String[] valeur = string.getValue().split(";");
				if (!facadeRole.exists("nom", valeur[0])) {
					jeu.setNom(valeur[0]);
					try {
						jeu.setDateSortie(DateConverter.changeDate(valeur[1]));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					jeu.setDescription(valeur[2]);
					jeu.setApercu(valeur[3]);

					if (facadeEditeur.exists("nom", valeur[5])) {
						editeur = facadeEditeur.searchFirstResult("nom", valeur[5]);
						System.out.println("Existe !");
					} else {
						editeur.setLogo(valeur[4]);
						editeur.setNom(valeur[5]);
						System.out.println("N'existe pas !");
					}

					jeu.setSysteme(valeur[6]);
					;
					jeu.setType(Type.valueOf(valeur[7]));
					;

					jeu.setEditeur(editeur);

					facadeRole.create(jeu);

					System.out.println("Creation OK");
				} else {
					System.out.println("Le jeu est déjà en base");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
