import model.walmart.Scraper;

public class Main {

    public static void main(String[] args) {
        Scraper scraper = new Scraper();
        scraper.scrape("https://www.walmart.ca/en/shop/weekly-flyer-features/6000196190101?icid=dept_flyout_other_weekly_flyer_features_30199_PHI81KCVEQ&page=28");

    }
}