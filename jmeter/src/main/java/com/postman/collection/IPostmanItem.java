package com.postman.collection;

public interface IPostmanItem {
    public IPostmanItem[] getItems();
    public IPostmanItem getItem(String key, boolean parent);
    public void addItem(IPostmanItem newItem, int position);
    public void removeItem(String key);
    public enumPostmanItemType getItemType();
    public String getName();
    
    
}
