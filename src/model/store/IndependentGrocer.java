package model.store;

import model.scraper.LobLawsScraperSuper;

public class IndependentGrocer extends LobLawsSuper {

    public IndependentGrocer(String name) {
        super(name);
        scraper = new LobLawsScraperSuper();
        initializeCategories();
    }

    public void initializeCategories() {
        categoriesURLs.put("Food", "https://www.yourindependentgrocer.ca/food/c/27985");
    }

}
