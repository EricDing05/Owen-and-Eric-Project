package model;


import model.store.AbstractStore;
import model.store.*;

public class test {

    public static void main(String[] args) {
        AbstractStore SuperStore = new SuperStore("SuperStore");  //save on, thriftys
        SuperStore.generateProducts();
        SuperStore.save();
    }

}

