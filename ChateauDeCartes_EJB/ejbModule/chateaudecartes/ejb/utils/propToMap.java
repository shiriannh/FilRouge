package chateaudecartes.ejb.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class propToMap {

	public static Map<String, String> propertiesToMap(Properties props) {
		HashMap<String, String> hm = new HashMap<String, String>();
		Enumeration<Object> e = props.keys();
		while (e.hasMoreElements()) {
			String s = (String) e.nextElement();
			hm.put(s, props.getProperty(s));
		}
		return hm;
	}
}
