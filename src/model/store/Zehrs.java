package model.store;

import model.persistance.JsonReader;
import model.persistance.JsonWriter;
import model.scraper.SuperStoreScraper;

public class Zehrs extends LobLawsSuper {

    public Zehrs(String name) {
        super(name);
        initializeCategories();
        scraper = new SuperStoreScraper();
        jsonWriter = new JsonWriter(".idea/data/Zehrs.json");
        this.jsonReader = new JsonReader(".idea/data/Zehrs.json");
        products = readProducts();
    }


    // EFFECTS: initializes all the categories and their URLs
    public void initializeCategories() {
        //the page with everything
        this.categoriesURLs.put("Food","https://www.zehrs.ca/food/c/27985");
    }

}
