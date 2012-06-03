package yammer4j;

import yammer4j.exception.YammerException;

final class OAuthImpl extends AbstractYammerApi
        implements OAuth {

    protected OAuthImpl(YammerHttpClient client) {
        super(client);
        // TODO 自動生成されたコンストラクター・スタブ
    }

    public String accessToken(String oAuthVerifier) {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    public String requestToken(String consumerKey, String consumerKeySecret) throws YammerException {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    // public boolean verify(String oAuthVerifier) throws ClientProtocolException, IOException {
    //
    // HttpPost httpPost = new HttpPost(ACCESS_TOKEN_URL);
    // httpPost = (HttpPost) addAuthorizeHeader(httpPost);
    // HttpResponse httpResponse = YammerHttpClient.request(httpPost);
    //
    // return httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK;
    // }

    // public HttpUriRequest addAuthorizeHeader(HttpUriRequest httpUriRequest) {
    // AuthHeaderBuilder ab = new AuthHeaderBuilder(AUTHORIZE_HEADER_OAUTH);
    // ab.append(OAUTH_CONSUMER_KEY, this.consumerKey)
    // .append(OAUTH_TOKEN, this.oAuthToken)
    // .append(OAUTH_SIGNATURE_METHOD, this.signatureMethod)
    // .append(OAUTH_VERIFIER, this.verifier)
    // .append(OAUTH_TIMESTAMP,
    // String.valueOf(System.currentTimeMillis()))
    // .append(OAUTH_SIGNATURE, this.signature)
    // .append(OAUTH_NONCE,
    // String.valueOf(Math.abs(this.nonce.nextInt())));
    //
    // httpUriRequest.addHeader(AUTHORIZE_HEADER, ab.toString());
    // return httpUriRequest;
    // }
    //
    // public String getAuthorizeUrl() {
    // return this.authorizeUrl;
    // }
    //
    // private class AuthHeaderBuilder {
    // StringBuilder sb;
    //
    // private AuthHeaderBuilder(String prefix) {
    // this.sb = new StringBuilder(AUTHORIZE_HEADER_OAUTH);
    // }
    //
    // private AuthHeaderBuilder append(String key, String value) {
    // if (key != null && value != null) {
    // sb.append(key).append("=").append(value).append(",");
    // }
    // return this;
    // }
    //
    // public String toString() {
    // return sb.toString();
    // }
    // }

}
