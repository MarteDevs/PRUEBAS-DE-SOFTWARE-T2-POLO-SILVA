package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.screenplay.questions.ResultadosDeBusqueda;
import edu.pe.cibertec.screenplay.tasks.BuscarProducto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class BusquedaStepDefinitions {

    @Given("the user is on the OpenCart home page")
    public void theUserIsOnTheOpenCartHomePage() {
        OnStage.theActorCalled("Usuario").attemptsTo(
                Open.url("https://naveenautomationlabs.com/opencart/index.php?route=common/home")
        );
    }

    @When("the user searches for the product {string}")
    public void theUserSearchesForTheProduct(String producto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                BuscarProducto.conNombre(producto)
        );
    }

    @Then("the user should see at least one result with the name {string}")
    public void theUserShouldSeeAtLeastOneResultWithTheName(String nombre) {
        List<String> resultados = ResultadosDeBusqueda.displayed()
                .answeredBy(OnStage.theActorInTheSpotlight());
        assertThat("Los resultados deben contener: " + nombre,
                resultados, hasItem(containsString(nombre)));
    }
}
