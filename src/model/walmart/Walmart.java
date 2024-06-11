package model.walmart;

import model.AbstractStore;

import java.util.ArrayList;

public class Walmart extends AbstractStore {


    public Walmart(String name) {
        super(name);
        this.scraper = new WalmartScraper();
        this.products = new ArrayList<>();
    }

    @Override
    public void generateProducts() {
        String url = "https://www.walmart.ca/en/shop/weekly-flyer-features/6000196190101?icid=dept_flyout_other_weekly_flyer_features_30199_PHI81KCVEQ&page=";
        for (int i = 0; i < 1000; i++) {
            try {
                products.addAll(scraper.scrape(url + i));
            } catch (Exception e) {
                throw e;
            }
            System.out.println(i);
        }
        System.out.println(products.size());
    }
}
