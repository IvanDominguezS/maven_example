package maven_basic_example;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	/*
	 * @param args
	 */
	public static void main(String[] args) {
		Main m = new Main();
		Properties ps = m.loadPropertiesFile("config.properties");
		
		Set props = ps.entrySet();
		Iterator it = props.iterator();
		while(it.hasNext()) {
			Entry<Object,Object> entrada = (Entry<Object,Object>) it.next();
			System.out.println(entrada.getKey() + " : " + entrada.getValue());
		}
	}
	
	private Properties loadPropertiesFile(String filePath) {
		Properties prop = new Properties();
		
		try(InputStream resourcesStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
			prop.load(resourcesStream);
		} catch (IOException e) {
			System.err.println("Unable to load properties file: " + filePath);
		}
		
		return prop;
	}
}
