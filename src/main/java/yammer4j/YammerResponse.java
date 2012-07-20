package yammer4j;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;

abstract class YammerResponse {

	private Integer statusCode;
	private String body;

	public YammerResponse(HttpResponse httpResponse) {
		this.setStatusCode(httpResponse.getStatusLine().getStatusCode());
		try {
			this.setBody(EntityUtils.toString(httpResponse.getEntity(),"UTF-8"));
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Integer getStatusCode() {
		return statusCode;
	}
	public String getBody() {
		return body;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public void setBody(String body) {
		this.body = body;
	}
}
