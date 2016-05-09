package entities.commons;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDate localDate) {
		if (localDate == null) {
			return null;
		} else {
			return java.sql.Date.valueOf(localDate);
		}

	}

	@Override
	public LocalDate convertToEntityAttribute(Date date) {
		if (date == null) {
			return null;
		} else {

			return date.toLocalDate();
		}
	}

}
