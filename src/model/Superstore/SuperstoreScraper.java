package model.Superstore;

import com.google.gson.JsonObject;
import model.Product;
import model.Scraper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class SuperstoreScraper extends Scraper {


    @Override
    public List<Product> parseArray(JsonObject o) {
        return null;
    }

    // EFFECTS: takes the url given by the String and scrapes data from it. Returns list of products
    // REQUIRES: valid url, throws RuntimeException if URL is invalid
    public void poop(String url) {
        try {
            // gets website data
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36")
                    .get();
            System.out.println(doc);
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
