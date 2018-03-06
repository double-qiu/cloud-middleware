package com.middleware.common.util.http;

import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建HttpReqHead
 */
public class HttpHeader {

    //记录head头信息
    private Map<String, Header> headerMaps = new HashMap<String, Header>();

    private HttpHeader() {
        headerMaps.put("jike-client-from", new BasicHeader("jike-client-from", "WEB"));
    }

    public static HttpHeader custom() {
        return new HttpHeader();
    }

    /**
     * 指定客户端能够接收的其他内容类型
     * 例如：Accept: text/plain, text/html
     */
    public HttpHeader put(String key, String value) {
        headerMaps.put(key, new BasicHeader(key, value));
        return this;
    }

    /**
     * 指定客户端能够接收的内容类型
     * 例如：Accept: text/plain, text/html
     */
    public HttpHeader accept(String accept) {
        headerMaps.put(HttpReqHead.ACCEPT, new BasicHeader(HttpReqHead.ACCEPT, accept));
        return this;
    }

    public String accept() {
        return get(HttpReqHead.ACCEPT);
    }

    /**
     * 浏览器可以接受的字符编码集
     * 例如：Accept-Charset: iso-8859-5
     */
    public HttpHeader acceptCharset(String acceptCharset) {
        headerMaps.put(HttpReqHead.ACCEPT_CHARSET, new BasicHeader(HttpReqHead.ACCEPT_CHARSET, acceptCharset));
        return this;
    }

    public String acceptCharset() {
        return get(HttpReqHead.ACCEPT_CHARSET);
    }

    /**
     * 指定浏览器可以支持的web服务器返回内容压缩编码类型
     * 例如：Accept-Encoding: compress, gzip
     */
    public HttpHeader acceptEncoding(String acceptEncoding) {
        headerMaps.put(HttpReqHead.ACCEPT_ENCODING, new BasicHeader(HttpReqHead.ACCEPT_ENCODING, acceptEncoding));
        return this;
    }

    public String acceptEncoding() {
        return get(HttpReqHead.ACCEPT_ENCODING);
    }

    /**
     * 浏览器可接受的语言
     * 例如：Accept-Language: en,zh
     */
    public HttpHeader acceptLanguage(String acceptLanguage) {
        headerMaps.put(HttpReqHead.ACCEPT_LANGUAGE, new BasicHeader(HttpReqHead.ACCEPT_LANGUAGE, acceptLanguage));
        return this;
    }

    public String acceptLanguage() {
        return get(HttpReqHead.ACCEPT_LANGUAGE);
    }

    /**
     * HTTP授权的授权证书
     * 例如：Authorization: Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==
     */
    public HttpHeader authorization(String authorization) {
        headerMaps.put(HttpReqHead.AUTHORIZATION, new BasicHeader(HttpReqHead.AUTHORIZATION, authorization));
        return this;
    }

    public String authorization() {
        return get(HttpReqHead.AUTHORIZATION);
    }

    /**
     * 指定请求和响应遵循的缓存机制
     * 例如：Cache-Control: no-cache
     */
    public HttpHeader cacheControl(String cacheControl) {
        headerMaps.put(HttpReqHead.CACHE_CONTROL, new BasicHeader(HttpReqHead.CACHE_CONTROL, cacheControl));
        return this;
    }

    public String cacheControl() {
        return get(HttpReqHead.CACHE_CONTROL);
    }

    /**
     * 表示是否需要持久连接（HTTP 1.1默认进行持久连接）
     * 例如：Connection: close 短链接； Connection: keep-alive 长连接
     */
    public HttpHeader connection(String connection) {
        headerMaps.put(HttpReqHead.CONNECTION, new BasicHeader(HttpReqHead.CONNECTION, connection));
        return this;
    }

    public String connection() {
        return get(HttpReqHead.CONNECTION);
    }

    /**
     * HTTP请求发送时，会把保存在该请求域名下的所有cookie值一起发送给web服务器
     * 例如：Cookie: $Version=1; Skin=new;
     */
    public HttpHeader cookie(String cookie) {
        headerMaps.put(HttpReqHead.COOKIE, new BasicHeader(HttpReqHead.COOKIE, cookie));
        return this;
    }

    public String cookie() {
        return get(HttpReqHead.COOKIE);
    }

    /**
     * 请求内容长度
     * 例如：Content-Length: 348
     */
    public HttpHeader contentLength(String contentLength) {
        headerMaps.put(HttpReqHead.CONTENT_LENGTH, new BasicHeader(HttpReqHead.CONTENT_LENGTH, contentLength));
        return this;
    }

    public String contentLength() {
        return get(HttpReqHead.CONTENT_LENGTH);
    }

    /**
     * 请求的与实体对应的MIME信息
     * 例如：Content-Type: application/x-www-form-urlencoded
     */
    public HttpHeader contentType(String contentType) {
        headerMaps.put(HttpReqHead.CONTENT_TYPE, new BasicHeader(HttpReqHead.CONTENT_TYPE, contentType));
        return this;
    }

    public String contentType() {
        return get(HttpReqHead.CONTENT_TYPE);
    }

    /**
     * 请求发送的日期和时间
     * 例如：Date: Tue, 15 Nov 2010 08:12:31 GMT
     */
    public HttpHeader date(String date) {
        headerMaps.put(HttpReqHead.DATE, new BasicHeader(HttpReqHead.DATE, date));
        return this;
    }

    public String date() {
        return get(HttpReqHead.DATE);
    }

    /**
     * 请求的特定的服务器行为
     * 例如：Expect: 100-continue
     */
    public HttpHeader expect(String expect) {
        headerMaps.put(HttpReqHead.EXPECT, new BasicHeader(HttpReqHead.EXPECT, expect));
        return this;
    }

    public String expect() {
        return get(HttpReqHead.EXPECT);
    }

    /**
     * 指定请求的服务器的域名和端口号
     * 例如：Host: blog.csdn.net
     */
    public HttpHeader host(String host) {
        headerMaps.put(HttpReqHead.HOST, new BasicHeader(HttpReqHead.HOST, host));
        return this;
    }

    public String host() {
        return get(HttpReqHead.HOST);
    }

    /**
     * 只有请求内容与实体相匹配才有效
     * 例如：If-Match: “737060cd8c284d8af7ad3082f209582d”
     */
    public HttpHeader ifMatch(String ifMatch) {
        headerMaps.put(HttpReqHead.IF_MATCH, new BasicHeader(HttpReqHead.IF_MATCH, ifMatch));
        return this;
    }

    public String ifMatch() {
        return get(HttpReqHead.IF_MATCH);
    }

    /**
     * 如果请求的部分在指定时间之后被修改则请求成功，未被修改则返回304代码
     * 例如：If-Modified-Since: Sat, 29 Oct 2010 19:43:31 GMT
     */
    public HttpHeader ifModifiedSince(String ifModifiedSince) {
        headerMaps.put(HttpReqHead.IF_MODIFIED_SINCE, new BasicHeader(HttpReqHead.IF_MODIFIED_SINCE, ifModifiedSince));
        return this;
    }

    public String ifModifiedSince() {
        return get(HttpReqHead.IF_MODIFIED_SINCE);
    }

    /**
     * 如果内容未改变返回304代码，参数为服务器先前发送的Etag，与服务器回应的Etag比较判断是否改变
     * 例如：If-None-Match: “737060cd8c284d8af7ad3082f209582d”
     */
    public HttpHeader ifNoneMatch(String ifNoneMatch) {
        headerMaps.put(HttpReqHead.IF_NONE_MATCH, new BasicHeader(HttpReqHead.IF_NONE_MATCH, ifNoneMatch));
        return this;
    }

    public String ifNoneMatch() {
        return get(HttpReqHead.IF_NONE_MATCH);
    }

    /**
     * 先前网页的地址，当前请求网页紧随其后,即来路
     * 例如：Referer: http://www.fclassroom.com
     */
    public HttpHeader referer(String referer) {
        headerMaps.put(HttpReqHead.REFERER, new BasicHeader(HttpReqHead.REFERER, referer));
        return this;
    }

    public String referer() {
        return get(HttpReqHead.REFERER);
    }

    /**
     * 向服务器指定某种传输协议以便服务器进行转换（如果支持）
     * 例如：Upgrade: HTTP/2.0, SHTTP/1.3, IRC/6.9, RTA/x11
     */
    public HttpHeader upgrade(String upgrade) {
        headerMaps.put(HttpReqHead.UPGRADE, new BasicHeader(HttpReqHead.UPGRADE, upgrade));
        return this;
    }

    public String upgrade() {
        return get(HttpReqHead.UPGRADE);
    }

    /**
     * User-Agent的内容包含发出请求的用户信息
     */
    public HttpHeader userAgent(String userAgent) {
        headerMaps.put(HttpReqHead.USER_AGENT, new BasicHeader(HttpReqHead.USER_AGENT, userAgent));
        return this;
    }

    public String userAgent() {
        return get(HttpReqHead.USER_AGENT);
    }

    public String from() {
        return get(HttpReqHead.FROM);
    }

    public String ifUnmodifiedSince() {
        return get(HttpReqHead.IF_UNMODIFIED_SINCE);
    }

    public String maxForwards() {
        return get(HttpReqHead.MAX_FORWARDS);
    }

    public String keepAlive() {
        return get(HttpReqHead.KEEP_ALIVE);
    }

    /**
     * 设置此HTTP连接的持续时间（超时时间）
     * 例如：Keep-Alive: 300
     */
    public HttpHeader keepAlive(String keepAlive) {
        headerMaps.put(HttpReqHead.KEEP_ALIVE, new BasicHeader(HttpReqHead.KEEP_ALIVE, keepAlive));
        return this;
    }

    /**
     * 获取head信息
     */
    private String get(String headName) {
        if (headerMaps.containsKey(headName)) {
            return headerMaps.get(headName).getValue();
        }
        return null;
    }

    /**
     * 返回header头信息
     */
    public Header[] build() {
        Header[] headers = new Header[headerMaps.size()];
        int i = 0;
        for (Header header : headerMaps.values()) {
            headers[i] = header;
            i++;
        }
        headerMaps.clear();
        return headers;
    }

    /**
     * Http头信息
     */
    private static class HttpReqHead {
        public static final String ACCEPT = "Accept";
        public static final String ACCEPT_CHARSET = "Accept-Charset";
        public static final String ACCEPT_ENCODING = "Accept-Encoding";
        public static final String ACCEPT_LANGUAGE = "Accept-Language";
        public static final String AUTHORIZATION = "Authorization";
        public static final String CACHE_CONTROL = "Cache-Control";
        public static final String CONNECTION = "Connection";
        public static final String COOKIE = "Cookie";
        public static final String CONTENT_LENGTH = "Content-Length";
        public static final String CONTENT_TYPE = "Content-Type";
        public static final String DATE = "Date";
        public static final String EXPECT = "Expect";
        public static final String FROM = "From";
        public static final String HOST = "Host";
        public static final String IF_MATCH = "If-Match";
        public static final String IF_MODIFIED_SINCE = "If-Modified-Since";
        public static final String IF_NONE_MATCH = "If-None-Match";
        public static final String IF_UNMODIFIED_SINCE = "If-Unmodified-Since";
        public static final String KEEP_ALIVE = "Keep-Alive";
        public static final String MAX_FORWARDS = "Max-Forwards";
        public static final String REFERER = "Referer";
        public static final String UPGRADE = "Upgrade";
        public static final String USER_AGENT = "User-Agent";
    }

    /**
     * 常用头信息配置
     */
    public static class Headers {
        public static final String APP_FORM_URLENCODED = "application/x-www-form-urlencoded";
        public static final String TEXT_PLAIN = "text/plain";
        public static final String TEXT_HTML = "text/html";
        public static final String TEXT_XML = "text/xml";
        public static final String TEXT_JSON = "text/json";
        public static final String CONTENT_CHARSET_ISO_8859_1 = Consts.ISO_8859_1.name();
        public static final String CONTENT_CHARSET_UTF8 = Consts.UTF_8.name();
        public static final String DEF_PROTOCOL_CHARSET = Consts.ASCII.name();
        public static final String CONN_CLOSE = "close";
        public static final String KEEP_ALIVE = "keep-alive";
        public static final String EXPECT_CONTINUE = "100-continue";
    }
}
