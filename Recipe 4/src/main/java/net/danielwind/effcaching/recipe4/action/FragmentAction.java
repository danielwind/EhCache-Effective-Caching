package net.danielwind.effcaching.recipe4.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class FragmentAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private static final String RESULT = "success";
	
	private static final Logger log = Logger.getLogger(FullPageAction.class);
	
	/**
	 * Execute Method (Required by Struts)
	 * @return
	 */
	public String execute() {
		log.info("--- Executing load action from Struts (Non-cached) in FragmentAction.class ---");
		return RESULT;
	}

}
