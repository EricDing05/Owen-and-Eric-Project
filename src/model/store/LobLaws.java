package model.store;

import model.persistance.JsonReader;
import model.persistance.JsonWriter;
import model.scraper.LobLawsScraperSuper;

public class LobLaws extends LobLawsSuper {

    public LobLaws(String name) {
        super(name);
        scraper = new LobLawsScraperSuper();
        initializeCategories();
        jsonWriter = new JsonWriter(".idea/data/LobLaws.json");
        this.jsonReader = new JsonReader(".idea/data/LobLaws.json");
        products = readProducts();
    }

    public void initializeCategories() {
        categoriesURLs.put("Food", "https://www.loblaws.ca/food/c/27985");
    }
}
