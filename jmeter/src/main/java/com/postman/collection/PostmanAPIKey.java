package com.postman.collection;

public class PostmanAPIKey {
    private String type = "";
    private String value = "";
    private String key = "";

    public PostmanAPIKey(String type, String value, String key) {
        this.type = type;
        this.value = value;
        this.key = key;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getKey() {
        return key;
    }
  
    public void setKey(String key) {
        this.key = key;
    }

    
    
}
