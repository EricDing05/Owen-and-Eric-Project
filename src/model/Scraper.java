package model;

import com.google.gson.JsonObject;

public abstract class Scraper {

    public abstract void scrape(String url);

    public abstract JsonObject JsonParser (String s);


}
