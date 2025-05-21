package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilter;
import com.api.models.request.LoginRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService { // wrapper for Rest Assured!!
//BASE URi
// CREATING THE REQUEST
//HANDLING THE RESPONSE

	private static final String BASE_URL = "https://reqres.in/api";
	private RequestSpecification requestSpecification;

	
	static {
		RestAssured.filters(new LoggingFilter());
	}
	public BaseService() {

		requestSpecification = given().baseUri(BASE_URL);
	}

	protected void setAuthToken(String token) {
		requestSpecification.header("x-api-key", token);
	}

	protected Response postRequest(Object payload, String endpoint) {
		setAuthToken("reqres-free-v1");
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}

	protected Response putRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
	}

	protected Response getRequest(String endpoint) {
		return requestSpecification.get(endpoint);
	}

	protected Response postRequest(String baseUrl, Object payload, String endpoint) {
		return requestSpecification.baseUri(baseUrl).contentType(ContentType.JSON).body(payload).post(endpoint);
	}

}
