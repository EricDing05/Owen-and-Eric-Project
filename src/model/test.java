package model;


import model.store.Costco;
import model.store.ThriftyFoods;
import model.store.*;

public class test {

    public static void main(String[] args) {
        AbstractStore Costco = new Costco("costco");  //save on, thriftys
        Costco.generateProducts();
        AbstractStore Thriftyfoods = new ThriftyFoods("Thriftyfoods");  //save on, thriftys
        Thriftyfoods.generateProducts();
        AbstractStore SaveOnFoods = new SaveOnFoods("SaveOnFoods");  //save on, thriftys

        SaveOnFoods.generateProducts();
        Costco.generateProducts();
        Thriftyfoods.generateProducts();

        Costco.saveProducts();
        Thriftyfoods.saveProducts();
        SaveOnFoods.saveProducts();

    }

}

