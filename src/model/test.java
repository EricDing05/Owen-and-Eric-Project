package model;

import model.scraper.SaveOnFoodsScraper;

public class test {

    public static void main(String[] args) {
        SaveOnFoodsScraper s = new SaveOnFoodsScraper();
        try {
            s.scrape();
        } catch (Exception e) {

        }


    }

}

