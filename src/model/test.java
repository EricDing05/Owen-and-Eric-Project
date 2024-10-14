package model;


import model.store.AbstractStore;
import model.store.LobLaws;

public class test {

    public static void main(String[] args) {
        AbstractStore Costco = new LobLaws("costco");  //save on, thriftys
        for (Product p : Costco.getProducts()) {
            System.out.println(p.getName());
        }
        System.out.println(Costco.getCategoriesURLs().values());
        Costco.generateProducts();
        Costco.save();
    }

}

