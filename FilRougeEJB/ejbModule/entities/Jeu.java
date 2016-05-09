package entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import entities.commons.LocalDateConverter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "jeu")
public class Jeu extends AbstractEntity {

	@Getter
	@Setter
	private String		nom;

	@Getter
	@Setter
	@Convert(converter = LocalDateConverter.class)
	@Column(nullable = false, name = "date_sortie")
	private LocalDate	dateSortie;

	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	private Genre		genre;

	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	private Support		support;

	public Jeu() {
	}

}
