package com.postman.collection;

public class PostmanUrl {
    private String raw = "";
    private String[] host;
    private String[] path;
    private PostmanQuery[] query;
    private PostmanVariable[] variable = null;
    
    public String getRaw() {
        return raw;
    }
    public void setRaw(String raw) {
        this.raw = raw;
    }
    public String[] getHosts() {
        return host;
    }
    public void setHosts(String[] host) {
        this.host = host;
    }
    public String[] getPaths() {
        return path;
    }
    public void setPaths(String[] path) {
        this.path = path;
    }
    public PostmanQuery[] getQueries() {
        return query;
    }
    public void setQueries(PostmanQuery[] query) {
        this.query = query;
    }
    public PostmanVariable[] getVariables() {
        return variable;
    }
    public void setVariables(PostmanVariable[] variable) {
        this.variable = variable;
    }
    
    
}
