package com.postman.collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

import com.google.gson.Gson;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import com.google.gson.Gson;


public class PostmanCollection extends PostmanItem 
{


//private PostmanItem[] item = null;
private PostmanInfo info = null;
//private PostmanEvent[] event = null;
private PostmanVariable[] variable = null;
private PostmanAuth auth = null;
//private PostmanItem parent = null;

/*public PostmanItem[] getItems() {
    return item;
}

public enumPostmanItemType getItemType() {
    return enumPostmanItemType.COLLECTION;
}
*/

public PostmanInfo getInfo() {
    return info;
}

public PostmanVariable[] getVariables() {
    return variable;
}

public PostmanAuth getAuth() {
    return auth;
}

public String getName() {
    return this.getInfo().getName() + "";
}

public String getDescription() {
    return this.getInfo().getDescription() + "";
}

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
        
        
        
            


    return pmcRetVal;
}

public PostmanItem getItemParent(String key) {
    return this.getItem(key, true);
}

/* public PostmanItem getItem(String key, boolean parent) {
    PostmanItem result = null;
    if (this.item == null)
    {
        return null;
    }
    //recursively traverse items looking for name == key
    for (PostmanItem curItem: item) {
        System.out.println("Parsing: " + this.getName() + " PARENT: " + parent);
        if (item == null)
          return null;
        if (curItem.getName().equals(key))
        {
            if (!parent) {
                result = curItem;
            }
            else
            {
                result = (PostmanItem) this;
            }
            
            break;
        }
        else
        {
            result = curItem.getItem(key, parent);
            if (result != null) {
                break;
            }
        }
        
    }

    return result;
}
 */
public Hashtable<String, PostmanRequest> getRequests() {
    return null;
}

@Override
public String getKey() {
    // TODO Auto-generated method stub
    return null;
}

@Override
public void setKey(String key) {
    // TODO Auto-generated method stub
    
}

}