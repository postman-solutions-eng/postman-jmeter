package com.postman.collection;


public class PostmanScript {
    private String type = "";
    private String[] exec;

    
    public PostmanScript(String Type, String[] Exec) {
            type = Type;
            exec = Exec;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public String[] getExec() {
        return exec;
    }


    public void setExec(String[] exec) {
        this.exec = exec;
    }

}
