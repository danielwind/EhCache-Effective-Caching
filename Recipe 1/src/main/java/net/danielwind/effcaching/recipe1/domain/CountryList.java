package net.danielwind.effcaching.recipe1.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "countryList")
public final class CountryList {

	@XmlElement(name="country")
	private List<Country> countryList;

	public List<Country> getCountries() {
		return countryList;
	}

	public void setCountries(List<Country> countryList) {
		this.countryList = countryList;
	}

}
