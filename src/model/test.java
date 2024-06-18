package model;

import model.store.SaveOnFoodsScraper;

public class test {

    public static void main(String[] args) {
        SaveOnFoodsScraper s = new SaveOnFoodsScraper();
        try {
            s.scrape();
        } catch (Exception e) {

        }


    }

}

