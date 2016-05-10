package chateaudecartes.ejb.entities;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import net.entetrs.commons.uuid.GeneratedUUID;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "id")
@ToString(of = { "id" })
@MappedSuperclass
public abstract class AbstractEntity {

	@Id
	@GeneratedUUID(format = "base64") // permet de génerer un UUID - lib ETRS
	@Getter // permet via lombok d'avoir un getter.
	String id;

}