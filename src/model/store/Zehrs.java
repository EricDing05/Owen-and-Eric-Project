package model.store;

import model.persistance.Writer;
import model.scraper.SuperStoreScraper;

public class Zehrs extends LobLawsSuper {

    public Zehrs(String name) {
        super(name);
        initializeCategories();
        scraper = new SuperStoreScraper();
        writer = new Writer(".idea/data/Zehrs.json");
    }


    // EFFECTS: initializes all the categories and their URLs
    public void initializeCategories() {
        //the page with everything
        this.categoriesURLs.put("Food","https://www.zehrs.ca/food/c/27985");
    }

}
