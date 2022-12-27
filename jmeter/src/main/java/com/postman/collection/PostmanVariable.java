package com.postman.collection;

public class PostmanVariable {
    private String key = "";
    private String value = "";
    private String type = "";
    
    public String getToken() {
        return "{{" + key + "}}";
    }
    
}
