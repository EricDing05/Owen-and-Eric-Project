package model.store;

import model.scraper.LobLawsScraperSuper;

public class AtlanticSuperStore extends LobLawsSuper {

    public AtlanticSuperStore(String name) {
        super(name);
        scraper = new LobLawsScraperSuper();
        initializeCategories();
    }

    public void initializeCategories() {
        categoriesURLs.put("Food", "https://www.atlanticsuperstore.ca/food/c/27985");
    }
}
