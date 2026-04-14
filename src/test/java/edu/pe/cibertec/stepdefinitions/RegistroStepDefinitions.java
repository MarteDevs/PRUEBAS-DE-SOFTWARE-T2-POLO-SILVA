package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.screenplay.tasks.RegistrarseComo;
import edu.pe.cibertec.screenplay.ui.RegistroPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.targets.Target;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class RegistroStepDefinitions {

    @Given("the user navigates to the register page")
    public void theUserNavigatesToTheRegisterPage() {
        OnStage.theActorCalled("Usuario").attemptsTo(
                Open.url("https://naveenautomationlabs.com/opencart/index.php?route=account/register")
        );
    }

    @When("the user fills the form with first name {string}, last name {string}, email {string}, phone {string} and password {string}")
    public void theUserFillsTheForm(String firstName, String lastName,
                                    String email, String phone, String password) {
        // Generamos un email único por ejecución para evitar el error "already registered"
        String uniqueEmail = email.replace("@", "_" + System.currentTimeMillis() + "@");

        OnStage.theActorInTheSpotlight().attemptsTo(
                RegistrarseComo.conDatos(firstName, lastName, uniqueEmail, phone, password)
        );
    }

    @And("accepts the privacy policy")
    public void acceptsThePrivacyPolicy() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(RegistroPage.AGREE_CHECKBOX)
        );
    }

    @And("clicks on continue")
    public void clicksOnContinue() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(RegistroPage.CONTINUE_BUTTON)
        );
    }

    @Then("the user should see the message {string}")
    public void theUserShouldSeeTheMessage(String expectedMessage) {
        String pageSource = Serenity.getDriver().getPageSource();
        assertThat("La página debe contener el texto: '" + expectedMessage + "'",
                pageSource, containsString(expectedMessage));
    }
}
