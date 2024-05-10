package model.walmart;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class walmartScraper extends model.Scraper {

    public void scrape(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            String json = doc.select("script#__NEXT_DATA__").first().html();
            JsonParser(json);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public JsonObject JsonParser(String s) {
        JsonObject jsonObject = JsonParser.parseString(s).getAsJsonObject();
        return jsonObject;
    }

    public void parseArray(JsonObject o) {
        JsonArray products = o.getAsJsonObject("props").getAsJsonObject("pageProps").getAsJsonObject("initialData").getAsJsonObject("searchResult").getAsJsonArray("itemStacks").get(0).getAsJsonObject().getAsJsonArray("items");
        for (int i = 0; i < products.size(); i++) {
            JsonObject product = products.get(i).getAsJsonObject();
            System.out.println("Product Name: " + product.get("name").getAsString());
            System.out.println("Price: " + product.get("price").getAsDouble());
        }

    }
}



