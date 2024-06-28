package model;

import model.store.NoFrills;


public class test {

    public static void main(String[] args) {
        AbstractStore Costco = new NoFrills("costco");
        System.out.println(Costco.getCategoriesURLs().values());
        Costco.generateProducts();
    }
}

