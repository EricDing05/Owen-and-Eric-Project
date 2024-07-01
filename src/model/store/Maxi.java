package model.store;

import model.scraper.LobLawsScraperSuper;

public class Maxi extends LobLawsSuper {

    public Maxi(String name) {
        super(name);
        scraper = new LobLawsScraperSuper();
        initializeCategories();
    }

    public void initializeCategories() {
        categoriesURLs.put("Food", "https://www.maxi.ca/food/c/27985");
    }

}
