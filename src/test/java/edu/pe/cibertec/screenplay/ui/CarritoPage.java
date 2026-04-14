package edu.pe.cibertec.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CarritoPage {

    public static final Target SEARCH_INPUT =
            Target.the("search input").locatedBy("//input[@name='search']");

    public static final Target SEARCH_BUTTON =
            Target.the("search button").locatedBy("#search button");

    public static final Target CART_TOTAL =
            Target.the("cart total counter").locatedBy("#cart-total");

    public static final Target CART_PAGE_PRODUCT_NAMES =
            Target.the("cart page product names")
                    .locatedBy("#content .table-responsive table tbody tr td:nth-child(2) a");
}
