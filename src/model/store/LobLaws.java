package model.store;

import model.scraper.LobLawsScraperSuper;

public class LobLaws extends LobLawsSuper {

    public LobLaws(String name) {
        super(name);
        scraper = new LobLawsScraperSuper();
        initializeCategories();
    }

    public void initializeCategories() {
        categoriesURLs.put("Food", "https://www.loblaws.ca/food/c/27985");
    }
}
