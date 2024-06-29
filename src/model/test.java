package model;

import model.store.*;


public class test {

    public static void main(String[] args) {
       // AbstractStore Costco = new Costco("costco");  //save on, thriftys
        //AbstractStore Thriftyfoods = new ThriftyFoods("Thriftyfoods");  //save on, thriftys
       // AbstractStore SaveOnFoods = new SaveOnFoods("SaveOnFoods");  //save on, thriftys
       // AbstractStore Walmart = new Walmart("Walmart"); //
        AbstractStore NoFrills = new NoFrills("NoFrills");

       // SaveOnFoods.generateProducts();
       // Costco.generateProducts();
        //Thriftyfoods.generateProducts();
      //  Walmart.generateProducts();
        NoFrills.generateProducts();

//        Costco.saveProducts();
//        Thriftyfoods.saveProducts();
//        SaveOnFoods.saveProducts();

    }

}

