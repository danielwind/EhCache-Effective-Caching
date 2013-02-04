package net.danielwind.effcaching.chapter6.utils;

public enum Role {

	MANAGER("Manager"),
	ENGINEER("Engineer"),
	OPERATOR("Operator"),
	ASSISTANT("Assistant"),
	SUPPORT("Support");
	
	private String description;
	
	private Role(String description) {
		this.description = description;
	}
	
	public static Role parseString(String role) {
		if(role != null){
		
			for(Role r : Role.values()){
				if(role.equalsIgnoreCase(r.description)) {
					return r;
				}
			}
		}
		
		throw new IllegalArgumentException("no constant found with role specified: " + role);
	}
}
