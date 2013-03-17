package net.danielwind.effcaching.recipe11.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import net.danielwind.effcaching.recipe11.domain.Message;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public final class JsonUtil {

	private static final String JSON_LOCATION = "messages.json";
	private static final Logger log = Logger.getLogger(JsonUtil.class);
	
	public static List<Message> parseFile() {
		
		//Jackson Mapper
		ObjectMapper mapper = new ObjectMapper();
		
		//Read .json file
		InputStream file = JsonUtil.class.getClassLoader().getResourceAsStream(JSON_LOCATION);
		
		//Parse Object List
		List<Message> messageList = null;
		
		try {
			messageList = mapper.readValue(file, new TypeReference<List<Message>>(){});
			
			for(Message message : messageList) {
				log.debug(message.toString());
			}
		
		} catch (IOException e) {
			
			e.printStackTrace();
		} 

		return messageList;
	} 

}
