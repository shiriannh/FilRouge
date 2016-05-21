package chateaudecartes.ejb.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "JEU")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@MappedSuperclass
public abstract class Jeu extends AbstractEntity {

	@Column
	String	nom;
	@Column
	Date	dateSortie;
	@Column(length = 900)
	String	description;
	@Column
	String	apercu;
	@ManyToOne
	Editeur	editeur;
}
