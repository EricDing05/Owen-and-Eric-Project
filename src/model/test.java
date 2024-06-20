package model;

import model.scraper.ThriftyScraper;
import model.store.ThriftyFoods;

public class test {

    public static void main(String[] args) {
        ThriftyFoods foods = new ThriftyFoods("thriftys");
        ThriftyScraper t = new ThriftyScraper();
        try {
            foods.generateProducts();
            // t.scrapePage("wdawd",new ThriftyFoods("thrify"), new SafariDriver());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}

