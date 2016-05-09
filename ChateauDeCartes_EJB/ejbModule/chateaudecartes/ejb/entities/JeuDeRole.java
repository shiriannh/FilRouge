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
@Table(name = "JEU_DE_ROLE")
public class JeuDeRole extends Jeu {

	@Column
	String	systeme;
	@Column
	String	genre;

}
