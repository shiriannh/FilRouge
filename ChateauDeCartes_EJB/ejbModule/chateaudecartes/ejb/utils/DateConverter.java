package chateaudecartes.ejb.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

	public static Date changeDate(String dateInString) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		Date date = formatter.parse(dateInString);

		return date;

	}

}
