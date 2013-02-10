package net.danielwind.effcaching.recipe6.cache;

import net.danielwind.effcaching.recipe6.domain.Employee;
import net.sf.ehcache.Element;
import net.sf.ehcache.search.attribute.AttributeExtractor;
import net.sf.ehcache.search.attribute.AttributeExtractorException;

public final class LastNameAttributeExtractor implements AttributeExtractor {

	private static final long serialVersionUID = 1L;

	public Object attributeFor(Element element) throws AttributeExtractorException {
		
		return attributeFor(element);
	}
	
	public Object attributeFor(Element element, String attributeName) {
		
		return ((Employee) element.getValue()).getLastName();
	}

}
