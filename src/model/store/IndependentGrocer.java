package model.store;

import model.persistance.JsonReader;
import model.persistance.JsonWriter;
import model.scraper.LobLawsScraperSuper;

public class IndependentGrocer extends LobLawsSuper {

    public IndependentGrocer(String name) {
        super(name);
        scraper = new LobLawsScraperSuper();
        initializeCategories();
        jsonWriter = new JsonWriter(".idea/data/IndependentGrocer.json");
        this.jsonReader = new JsonReader(".idea/data/IndependentGrocer.json");
        products = readProducts();
    }

    public void initializeCategories() {
        categoriesURLs.put("Food", "https://www.yourindependentgrocer.ca/food/c/27985");
    }

}
