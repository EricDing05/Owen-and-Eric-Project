import model.AbstractStore;
import model.Product;
import model.store.Costco;

public class Main {

    public static void main(String[] args) {
        AbstractStore costco = new Costco("Costco");
        costco.generateProducts();

        for(Product p : costco.getProducts()) {
            System.out.println(p.getName() + " " + p.getName());
        }

    }
}

