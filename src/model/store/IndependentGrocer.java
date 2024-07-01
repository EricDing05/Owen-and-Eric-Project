package model.store;

import model.persistance.Writer;
import model.scraper.LobLawsScraperSuper;

public class IndependentGrocer extends LobLawsSuper {

    public IndependentGrocer(String name) {
        super(name);
        scraper = new LobLawsScraperSuper();
        initializeCategories();
        writer = new Writer(".idea/data/IndependentGrocer.json");
    }

    public void initializeCategories() {
        categoriesURLs.put("Food", "https://www.yourindependentgrocer.ca/food/c/27985");
    }

}
