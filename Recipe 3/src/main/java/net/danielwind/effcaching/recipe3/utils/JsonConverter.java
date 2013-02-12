package net.danielwind.effcaching.recipe3.utils;

import com.google.gson.Gson;

public final class JsonConverter {
	
	public static String toJson(Object object) {
		return new Gson().toJson(object);
	} 

}
