package com.postman.collection;
import com.google.gson.*;

public abstract class PostmanCollectionElement {
    public String toJson(boolean escaped) {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public abstract void setKey(String key);
    public abstract String getKey();
}
