package model;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public abstract class Scraper {

    // EFFECTS: takes the url given by the String and scrapes data from it. Returns list of products
    // REQUIRES: valid url, throws RuntimeException if URL is invalid
    public List<Product> scrape(String url) {
        try {
            // gets website data
            Document doc = Jsoup.connect(url).get();

            // TODO: We want to wrap this with a try-catch in case we run into an anti-bot screen.
            // selects relevant portion of the website data
            String json = doc.select("script#__NEXT_DATA__").first().html();

            // parses the JsonObject that contains the website data
            return parseArray(JsonParser(json));
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    // EFFECTS: turns the String collected from the website into a readable JSONObject
    public JsonObject JsonParser(String s) {
        JsonObject jsonObject = JsonParser.parseString(s).getAsJsonObject();
        return jsonObject;
    }

    public abstract List<Product> parseArray(JsonObject o);


}
