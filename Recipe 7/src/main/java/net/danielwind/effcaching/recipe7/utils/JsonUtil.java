package net.danielwind.effcaching.recipe7.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import net.danielwind.effcaching.recipe7.domain.Person;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public final class JsonUtil {

	private static final String JSON_LOCATION = "src/main/resources/people.json";
	private static final Logger log = Logger.getLogger(JsonUtil.class);
	
	public static List<Person> parseFile() {
		
		//Jackson Mapper
		ObjectMapper mapper = new ObjectMapper();
		
		//Read .json file
		File file = new File(JSON_LOCATION);
		
		//Parse Object List
		List<Person> peopleList = null;
		
		try {
			peopleList = mapper.readValue(file, new TypeReference<List<Person>>(){});
			
			for(Person person : peopleList) {
				log.debug(person.toString());
			}
		
		} catch (IOException e) {
			
			e.printStackTrace();
		} 

		return peopleList;
	} 

}
