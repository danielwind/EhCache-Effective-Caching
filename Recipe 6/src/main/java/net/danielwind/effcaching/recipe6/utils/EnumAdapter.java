package net.danielwind.effcaching.recipe6.utils;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.log4j.Logger;

public class EnumAdapter extends XmlAdapter<String, Enum<?>> {

	private static final Logger log = Logger.getLogger(EnumAdapter.class);
	private static final Class<Role> enumClass = Role.class;
	
	@Override
	public Enum<?> unmarshal(String v) throws Exception {
		
		try {
			return (Enum<?>) Enum.valueOf(enumClass, v.toUpperCase());
		}catch(IllegalArgumentException e){
			log.error("Argument cannot be recognized as Role: " + v);
		}
		
		return null;
	}

	@Override
	public String marshal(Enum<?> v) throws Exception {
		return v.toString();
	}

}
