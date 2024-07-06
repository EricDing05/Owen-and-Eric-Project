package model.store;

import model.persistance.JsonReader;
import model.persistance.JsonWriter;
import model.scraper.SuperStoreScraper;

public class SuperStore extends LobLawsSuper {

    // EFFECTS: Creates an instance of a store
    public SuperStore(String name) {
        super(name);
        initializeCategories();
        scraper = new SuperStoreScraper();
        jsonWriter = new JsonWriter(".idea/data/SuperStore.json");
        this.jsonReader = new JsonReader(".idea/data/SuperStore.json");
        products = readProducts();
    }


    // EFFECTS: initializes all the categories and their URLs
    public void initializeCategories() {
        //the page with everything
        this.categoriesURLs.put("Food","https://www.realcanadiansuperstore.ca/food/c/27985");
    }

}
