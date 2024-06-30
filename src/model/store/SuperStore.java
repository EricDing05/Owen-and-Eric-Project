package model.store;

import model.persistance.Writer;
import model.scraper.SuperStoreScraper;

public class SuperStore extends LobLawsSuper {

    // EFFECTS: Creates an instance of a store
    public SuperStore(String name) {
        super(name);
        initializeCategories();
        scraper = new SuperStoreScraper();
        writer = new Writer("/Users/ericding/IdeaProjects/App/.idea/data/SuperStore.json");
    }


    // EFFECTS: initializes all the categories and their URLs
    public void initializeCategories() {
        //the page with everything
        this.categoriesURLs.put("Food","https://www.realcanadiansuperstore.ca/food/c/27985");
    }

}
