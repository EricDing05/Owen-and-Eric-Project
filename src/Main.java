import model.Product;
import model.store.AbstractStore;
import model.store.ThriftyFoods;

public class Main {

    public static void main(String[] args) {
        AbstractStore costco = new ThriftyFoods("Costco");
        costco.generateProducts();

        for(Product p : costco.getProducts()) {
            System.out.println(p.getName() + " " + p.getName());
        }

    }
}

