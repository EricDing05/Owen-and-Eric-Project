package Model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Scraper {

    public static void scrape(String url) {
        try  {
            Document doc = Jsoup.connect(url).get();
            System.out.println(doc.title());
            System.out.println(doc);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }


}
