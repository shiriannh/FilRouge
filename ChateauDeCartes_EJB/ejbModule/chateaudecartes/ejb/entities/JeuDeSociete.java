package chateaudecartes.ejb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "JEU_DE_SOCIETE")
public class JeuDeSociete extends Jeu {

	@Column
	int		nbrDeJoueurs;
	@Column
	// True si le jeu est un jeu de plateau, false si c'est un jeu de carte.
	boolean	plateauCarte;
}
