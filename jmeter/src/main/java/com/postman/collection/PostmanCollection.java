package com.postman.collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import com.google.gson.Gson;


public class PostmanCollection {


private PostmanItem[] item = null;

private PostmanInfo info = null;
private PostmanEvent[] event = null;
private PostmanVariable[] variable = null;
//private Gson _gson = null;
private String _json = "";



public static PostmanCollection PMCFactory(String pathToJson) throws FileNotFoundException, IOException {
    PostmanCollection pmcRetVal = null;
    String strChunk = "";
    BufferedReader brItem = null;
    String strRawItem = "";
    Gson gson = null;
    

    brItem = new BufferedReader(new FileReader(new File(pathToJson)));
        while((strChunk = brItem.readLine()) != null)
            strRawItem = strRawItem + strChunk;
        try {
            brItem.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        gson = new Gson();
        pmcRetVal = gson.fromJson(strRawItem, PostmanCollection.class);
        pmcRetVal.setJson(strRawItem);
            


    return pmcRetVal;
}

public void setJson(String json) {
   this._json = json;
}

public String getJson() {
    Gson gson = new Gson();
    return gson.toJson(this);
}

public void setName(String name) {
    this.info.setName(name);
}

public String getName() {
    return this.info.getName();
}

/* public String toJson() {
    return this._gson.toJson(this);
} */
   
    
}