package net.danielwind.effcaching.recipe9;


import net.danielwind.effcaching.recipe9.pages.ApplicationHomePage;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

public class RecipeApplication extends WebApplication {

	@Override
	public Class<? extends Page> getHomePage() {
		
		return ApplicationHomePage.class;
	}
	
	@Override
	protected void init() {
		
		super.init();
		
		//initialize Spring
		getComponentInstantiationListeners().add(new SpringComponentInjector(this));
	}

}
