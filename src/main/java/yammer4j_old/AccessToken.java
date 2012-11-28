package yammer4j_old;

import java.io.Serializable;

public class AccessToken implements Serializable,Token{

	private static final long serialVersionUID = -8716651959215433102L;

	private String token;

	void setToken(String token){
		this.token = token;
	}

	public String getToken() {
		return this.token;
	}

}
