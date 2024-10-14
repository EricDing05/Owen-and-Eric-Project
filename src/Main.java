import model.Product;
import model.store.AbstractStore;
import model.store.LobLaws;

public class Main {

    public static void main(String[] args) {
        AbstractStore costco = new LobLaws("Costco");
        costco.generateProducts();

        for(Product p : costco.getProducts()) {
            System.out.println(p.getName() + " " + p.getName());
        }

    }
}

