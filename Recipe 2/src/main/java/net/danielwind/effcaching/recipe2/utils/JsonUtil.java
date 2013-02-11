package net.danielwind.effcaching.recipe2.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import net.danielwind.effcaching.recipe2.domain.Car;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public final class JsonUtil {

	private static final String JSON_LOCATION = "src/main/resources/cars.json";
	private static final Logger log = Logger.getLogger(JsonUtil.class);
	
	public List<Car> parseFile() {
		
		//Jackson Mapper
		ObjectMapper mapper = new ObjectMapper();
		
		//Read .json file
		File file = new File(JSON_LOCATION);
		
		//Parse Object List
		List<Car> carList = null;
		
		try {
			carList = mapper.readValue(file, new TypeReference<List<Car>>(){});
			
			for(Car car : carList) {
				log.debug(car.toString());
			}
		
		} catch (IOException e) {
			
			e.printStackTrace();
		} 

		return carList;
	} 

}
