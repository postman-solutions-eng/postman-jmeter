package com.postman.collection;

public class PostmanResponse {
    private String name = "";
    private PostmanRequest originalRequest = null;
    private int code;
    private String status;
    private String _postman_previewlanguage = "";
    private PostmanCookie[] cookie = null;
    private String body = "";

    public PostmanResponse(String name, PostmanRequest originalRequest, int code, String status,
            String _postman_previewlanguage, PostmanCookie[] cookie, String body) {
        this.name = name;
        this.originalRequest = originalRequest;
        this.code = code;
        this.status = status;
        this._postman_previewlanguage = _postman_previewlanguage;
        this.cookie = cookie;
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PostmanRequest getOriginalRequest() {
        return originalRequest;
    }

    public void setOriginalRequest(PostmanRequest originalRequest) {
        this.originalRequest = originalRequest;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String get_postman_previewlanguage() {
        return _postman_previewlanguage;
    }

    public void set_postman_previewlanguage(String _postman_previewlanguage) {
        this._postman_previewlanguage = _postman_previewlanguage;
    }

    public PostmanCookie[] getCookies() {
        return cookie;
    }

    public void setCookies(PostmanCookie[] cookie) {
        this.cookie = cookie;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    

}
