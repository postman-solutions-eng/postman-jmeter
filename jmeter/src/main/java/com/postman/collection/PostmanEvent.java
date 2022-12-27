package com.postman.collection;

public class PostmanEvent {
    
private String listen = ""; // basically the name
private PostmanScript script = null;

public PostmanEvent(String listen, PostmanScript script) {
    this.listen = listen;
    this.script = script;
}

public String getListen() {
    return listen;
}

public void setListen(String listen) {
    this.listen = listen;
}
public PostmanScript getScript() {
    return script;
}
public void setScript(PostmanScript script) {
    this.script = script;
}





}
