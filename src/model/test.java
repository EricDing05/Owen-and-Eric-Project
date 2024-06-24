package model;

import model.store.SaveOnFoods;


public class test {

    public static void main(String[] args) {
        AbstractStore Costco = new SaveOnFoods("costco");
        System.out.println(Costco.getCategoriesURLs().values());
        Costco.generateProducts();
    }
}

