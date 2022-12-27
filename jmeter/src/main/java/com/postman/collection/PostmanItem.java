package com.postman.collection;


public class PostmanItem {
    
    
    private String name;
    private String description;
    private PostmanEvent[] event = null;
    private PostmanRequest request = null;
    private PostmanResponse[] response = null;
    private PostmanItem[] item;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public PostmanEvent[] getEvents() {
        return event;
    }
    public void setEvents(PostmanEvent[] event) {
        this.event = event;
    }
    public PostmanRequest getRequest() {
        return request;
    }
    public void setRequest(PostmanRequest request) {
        this.request = request;
    }
    public PostmanResponse[] getResponses() {
        return response;
    }
    public void setResponses(PostmanResponse[] response) {
        this.response = response;
    }
    public PostmanItem[] getItems() {
        return item;
    }
    public void setItems(PostmanItem[] item) {
        this.item = item;
    }
    
    

   
    
    
    
    
}
