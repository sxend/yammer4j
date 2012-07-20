package yammer4j;

import org.apache.http.HttpResponse;


final class LikesImpl extends AbstractYammerApi implements Likes {

	protected LikesImpl(YammerHttpClient client) {
		super(client);
	}

	@Override
	protected YammerResponse parsingObject(HttpResponse httpResponse) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
