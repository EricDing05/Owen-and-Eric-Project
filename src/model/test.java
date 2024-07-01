package model;


import model.store.AbstractStore;
import model.store.ThriftyFoods;

public class test {

    public static void main(String[] args) {
        AbstractStore Costco = new ThriftyFoods("costco");  //save on, thriftys
        System.out.println(Costco.getCategoriesURLs().values());
        Costco.generateProducts();
        Costco.save();
    }

}

