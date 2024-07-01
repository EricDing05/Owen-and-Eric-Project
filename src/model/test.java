package model;


import model.store.AbstractStore;
import model.store.NoFrills;

public class test {

    public static void main(String[] args) {
        AbstractStore Costco = new NoFrills("costco");  //save on, thriftys
        System.out.println(Costco.getCategoriesURLs().values());
        Costco.generateProducts();
        Costco.save();
    }

}

