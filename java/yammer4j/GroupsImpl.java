package yammer4j;

import org.apache.http.HttpResponse;


final class GroupsImpl extends AbstractYammerApi implements Groups {

	protected GroupsImpl(YammerHttpClient client) {
		super(client);
	}

	@Override
	protected YammerResponse parsingObject(HttpResponse httpResponse) {
		return null;
	}

}
