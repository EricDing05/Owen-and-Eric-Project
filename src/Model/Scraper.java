package Model;

import com.google.gson.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.FileWriter;
import java.io.IOException;

public class Scraper {

    public static void scrape(String url) {
        try  {
            Document doc = Jsoup.connect(url).get();
            String json = doc.select("script#__NEXT_DATA__").first().html();
            JsonParser(json);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private static void JsonParser(String s) {
        JsonObject jsonObject = JsonParser.parseString(s).getAsJsonObject();
        JsonArray object = jsonObject.getAsJsonArray("products");
        // Instantiate Gson
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Write JSON to file
        try (FileWriter file = new FileWriter("output.json")) {
            gson.toJson(jsonObject, file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
