package net.danielwind.effcaching.recipe9.pages;

import java.util.List;

import net.danielwind.effcaching.recipe9.domain.Employee;
import net.danielwind.effcaching.recipe9.services.ApplicationService;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class ApplicationHomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	@SpringBean
	private ApplicationService applicationService;
	
	public ApplicationHomePage(PageParameters parameters) {
		
		super(parameters);
		
		//initiate GUI
		addEmployeesModule();
	}
	
	private void addEmployeesModule() {
		
		ListView<Employee> employees = new ListView<Employee>("employees", createModelForEmployees()){
			
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Employee> item){
				item.add(new Label("id", new PropertyModel<Employee>(item.getModel(), "id")));
				item.add(new Label("firstName", new PropertyModel<Employee>(item.getModel(), "firstName")));
				item.add(new Label("lastName", new PropertyModel<Employee>(item.getModel(), "lastName")));
				item.add(new Label("department", new PropertyModel<Employee>(item.getModel(), "department")));
				item.add(new Label("role", new PropertyModel<Employee>(item.getModel(), "role")));
				item.add(new Label("salary", new PropertyModel<Employee>(item.getModel(), "salary")));
			}
		};
		
		add(employees);
	}
	
	private LoadableDetachableModel<List<Employee>> createModelForEmployees() {
		
		return new LoadableDetachableModel<List<Employee>>() {

			private static final long serialVersionUID = 1L;

			@Override
			protected List<Employee> load() {
				return applicationService.getAllEmployees();
			}
		};
	}

}
