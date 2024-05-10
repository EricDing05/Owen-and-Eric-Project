package Model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Scraper {

    public static void scrape(String url) {
        try  {
            Document doc = Jsoup.connect(url).get();
            String json = doc.select("script#__NEXT_DATA__").first().html();
            System.out.println(json);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private void JsonParser(String s) {

    }


}
