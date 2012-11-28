package yammer4j_old;

import java.io.Serializable;


public class UnAuthorisedToken implements Serializable,Token{

	private static final long serialVersionUID = -5103301134483315031L;
	private String token;

	public String getToken() {
		return this.token;
	}
	void setToken(String token){
		this.token = token;
	}
}
