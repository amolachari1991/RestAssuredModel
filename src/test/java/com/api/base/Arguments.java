package com.api.base;

public enum Arguments {	

	registrationSchemaPath("jsonSchemas/registration.json");

	private String arguments;
	
	Arguments(String arguments) {
		this.arguments = arguments;
	}
	
	public String getArgument() {
		
		return arguments;
	}
	
	
}


