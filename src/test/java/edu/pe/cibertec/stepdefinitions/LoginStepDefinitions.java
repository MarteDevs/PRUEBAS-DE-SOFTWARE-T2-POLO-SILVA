package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.screenplay.tasks.IniciarSesionComo;
import edu.pe.cibertec.screenplay.ui.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;

public class LoginStepDefinitions {

    @Given("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage() {
        OnStage.theActorCalled("Usuario").attemptsTo(
                Open.url("https://naveenautomationlabs.com/opencart/index.php?route=account/login")
        );
    }

    @When("the user enters email {string} and password {string}")
    public void theUserEntersEmailAndPassword(String email, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IniciarSesionComo.conCredenciales(email, password)
        );
    }

    @And("clicks on the login button")
    public void clicksOnTheLoginButton() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }
}
