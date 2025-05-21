package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;



//@Listeners(com.api.listeners.TestListener.class)
public class AccountCreationTest {
	@Test(description = "Verify if AccountCreation API is working...")

	public void createAccountTest() {
		
		SignUpRequest signUpRequest=new SignUpRequest.Builder()
		.email("eve.holt@reqres.in")
		.password("pistol")
		.build();
		
		
		AuthService authService = new AuthService();
		Response response=authService.signUp(signUpRequest);
		String path = "jsonSchemas/registration.json";

		 ValidatableResponse t=authService.schemaValidaton(response, path);
		Assert.assertEquals(response.statusCode(), 200);

		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		Assert.assertEquals(userProfileResponse.getId(), 4);
		Assert.assertEquals(userProfileResponse.getToken(), "QpwL5tke4Pnpja7X4");


	}
}
