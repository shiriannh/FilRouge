package chateaudecartes.jsf.beans;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import chateaudecartes.ejb.entities.Type;
import lombok.extern.apachecommons.CommonsLog;

@FacesConverter(forClass = chateaudecartes.ejb.entities.Type.class)
@CommonsLog
public class TypeConverter implements Converter {

	public static final String MSG = "impossible a convertir";

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null) {
			String typeSaisie = value.toString().toUpperCase();
			try {
				Type t = Type.valueOf(typeSaisie);
				return t;
			} catch (IllegalArgumentException e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, MSG, MSG));
			}
		} else {
			throw new ConverterException(MSG);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null && value instanceof Type) {
			return ((Type) value).toString();
		} else {
			return null;
		}
	}

}
