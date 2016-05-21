package chateaudecartes.ejb.entities;

import org.springframework.util.StringUtils;

/**
 * toutes les marques de guitares.
 * 
 * @author utilisateur
 *
 */
public enum Type {

	FANTASY(), SCIFI, STEAMPUNK, CYBERPUNK, FARWEST, MODERNE, ORIENTAL, APOCALYPSE, FUTURISTE, ANTICIPATION, SPACE_OPERA;

	private final String firstUpperCase;

	/**
	 * calcule la marque avec seulement la première lettre en majuscules.
	 */
	private Type() {
		firstUpperCase = StringUtils.capitalize(this.name().toLowerCase());
	}

	/**
	 * retourne une chaine de caractère représentant la marque avec seulement la
	 * première lettre en majuscules.
	 * 
	 * @return la marque avec seulement la première lettre en majuscules
	 * 
	 */
	public String withFirstUpperCase() {
		return firstUpperCase;
	}

	/**
	 * comparator static pour être utilisé en expression lambda pour du tri
	 * (sort).
	 * 
	 * @param m1
	 * @param m2
	 * @return
	 */
	public static int alphabetical(Type m1, Type m2) {
		return m1.name().compareTo(m2.name());
	}

}
