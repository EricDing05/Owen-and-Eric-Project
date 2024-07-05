package model.store;

import model.persistance.JsonReader;
import model.persistance.JsonWriter;
import model.scraper.LobLawsScraperSuper;

public class AtlanticSuperStore extends LobLawsSuper {

    public AtlanticSuperStore(String name) {
        super(name);
        scraper = new LobLawsScraperSuper();
        initializeCategories();
        jsonWriter = new JsonWriter(".idea/data/AtlanticSuperStore.json");
        this.jsonReader = new JsonReader(".idea/data/AtlanticSuperStore.json");
        products = readProducts();
    }

    public void initializeCategories() {
        categoriesURLs.put("Food", "https://www.atlanticsuperstore.ca/food/c/27985");
    }
}
