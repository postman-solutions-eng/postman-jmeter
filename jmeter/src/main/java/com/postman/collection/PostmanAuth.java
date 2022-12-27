package com.postman.collection;

public class PostmanAuth {
    
    private String type = "";
    private PostmanAPIKey[] apikey = null;
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PostmanAPIKey[] getApikey() {
        return apikey;
    }

    public void setApikey(PostmanAPIKey[] apikey) {
        this.apikey = apikey;
    }

    public PostmanAuth(String type, PostmanAPIKey[] apikey) {
        this.type = type;
        this.apikey = apikey;
    }

}
