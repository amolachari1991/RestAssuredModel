package com.api.models.response;

public class UserProfileResponse {
	private int id;
	private String token;

	
	public UserProfileResponse() {
		// TODO Auto-generated constructor stub
	}
	
	
	public UserProfileResponse(int id, String username) {
		super();
		this.id = id;
		this.token = token;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}


	@Override
	public String toString() {
		return "UserProfileResponse [id=" + id + ", token=" + token + "]";
	}
	
	
}
