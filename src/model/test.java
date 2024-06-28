package model;


import model.store.Walmart;

public class test {

    public static void main(String[] args) {
        AbstractStore Costco = new Walmart("costco");  //save on, thriftys
        System.out.println(Costco.getCategoriesURLs().values());
        Costco.generateProducts();
    }

}

