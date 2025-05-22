package com.api.tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.api.base.Arguments;
import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;



//@Listeners(com.api.listeners.TestListener.class)
public class AccountCreationTest {
	
	@Test(dataProvider = "userData" , description = "Verify if AccountCreation API is working...")
	public void createAccountTest(String name, String email) {
		//creating payload with pojoRequest.class
		SignUpRequest signUpRequest=new SignUpRequest.Builder()
		.email(email)
		.password(name)
		.build();
		
		//main service class object to access API's belonging to it
		AuthService authService = new AuthService();
		Response response=authService.signUp(signUpRequest);
		
		//Json schema validation
		String path = Arguments.registrationSchemaPath.getArgument();
		authService.schemaValidaton(response, path);

		//assertions using pojoResponse.class
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		Assert.assertEquals(userProfileResponse.getId(), 4);
		Assert.assertEquals(userProfileResponse.getToken(), "QpwL5tke4Pnpja7X4");


	}
	
	@DataProvider(name = "userData" , parallel = true)
	public Object[][] createUserData() {
	    return new Object[][] {
	        {"pistol", "eve.holt@reqres.in"},
	        {"pistol", "eve.holt@reqres.in"},
//	        {"Bob", "bob@example.com"}
	    };
	}



}
