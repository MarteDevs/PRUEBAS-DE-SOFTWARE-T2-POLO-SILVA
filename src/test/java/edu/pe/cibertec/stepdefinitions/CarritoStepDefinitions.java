package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.screenplay.questions.ContadorDelCarrito;
import edu.pe.cibertec.screenplay.tasks.AgregarAlCarrito;
import edu.pe.cibertec.screenplay.ui.CarritoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

public class CarritoStepDefinitions {
    @When("the user adds the product {string} to the cart")
    public void theUserAddsTheProductToTheCart(String producto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AgregarAlCarrito.elProducto(producto)
        );
    }

    @Then("the cart should show {string}")
    public void theCartShouldShow(String expectedCounter) {
        String contador = ContadorDelCarrito.actual()
                .answeredBy(OnStage.theActorInTheSpotlight());
        assertThat("El carrito debe mostrar: " + expectedCounter, contador, is(expectedCounter));
    }

    @And("navigates to the cart")
    public void navigatesToTheCart() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Open.url("https://naveenautomationlabs.com/opencart/index.php?route=checkout/cart")
        );
    }

    @Then("the user should see the product {string} in the cart list")
    public void theUserShouldSeeTheProductInTheCartList(String producto) {
        List<String> productosEnCarrito = CarritoPage.CART_PAGE_PRODUCT_NAMES
                .resolveAllFor(OnStage.theActorInTheSpotlight())
                .stream()
                .map(e -> e.getText().trim())
                .collect(Collectors.toList());

        assertThat("El carrito debe contener el producto: " + producto,
                productosEnCarrito, hasItem(containsString(producto)));
    }
}
