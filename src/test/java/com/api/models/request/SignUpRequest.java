package com.api.models.request;

public class SignUpRequest {
	private String email;
	private String password;


	private SignUpRequest(String email, String password) {
		super();
		this.password = password;
		this.email = email;

	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}




	public static class Builder {
		private String username;
		private String password;
		private String email;


		public Builder userName(String username) {
			this.username = username;
			Builder x = this;
			return x;
		}

		public Builder password(String password) {
			this.password = password;
			return this;// current object
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}


		public SignUpRequest build() {
			SignUpRequest signUpRequest = new SignUpRequest(email, password);
			return signUpRequest;
		}
	}




	@Override
	public String toString() {
		return "SignUpRequest [email=" + email + ", password=" + password + "]";
	}

}
