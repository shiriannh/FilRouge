package chateaudecartes.ejb.entities;

import java.sql.Blob;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "EDITEUR")
public class Editeur extends AbstractEntity {

	@Column
	String		nom;
	@Column
	Blob		logo;
	@OneToMany
	List<Jeu>	jeux;

}
