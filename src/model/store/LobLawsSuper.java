package model.store;



public abstract class LobLawsSuper extends AbstractStore {

    public LobLawsSuper(String name) {
        super(name);
        initializeCategories();
        this.setNoMoreProductsPath("a.chakra-link.css-haqcta[aria-label=\"Next Page\"]"); //TODO
        this.setNoMoreProductsString("");

    }

    // EFFECTS: returns the next page of a given URL
    public String getNextURL(String url, int i) {
        return url + "?page=" + (i + 1); //this
    }

    // EFFECTS: Generates/updates all products of this store
    public void generateProducts() {
        this.scraper.scrapeWebsite(this);
    }

    public abstract void initializeCategories();



}
