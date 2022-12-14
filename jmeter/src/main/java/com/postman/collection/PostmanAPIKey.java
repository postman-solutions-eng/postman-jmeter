package com.postman.collection;

import com.google.gson.*;;

public class PostmanAPIKey implements IPostmanCollectionElement {
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



    @Override
    public String toJson(boolean escaped, enumVariableResolution variableStrategy) {
        
        return  new Gson().toJson(this);
    }

    
    
}
