package edu.pe.cibertec.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

public class BusquedaPage {
    public static final Target SEARCH_INPUT =
            Target.the("search input").locatedBy("//input[@name='search']");

    public static final Target SEARCH_BUTTON =
            Target.the("search button").locatedBy("#search button");

    public static final Target PRODUCT_NAMES =
            Target.the("product names in results").locatedBy(".product-layout h4 a");

    public static final Target NO_RESULTS_MESSAGE =
            Target.the("no results message").locatedBy("#content > p");
}
