package edu.pe.cibertec.screenplay.tasks;

import edu.pe.cibertec.screenplay.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IniciarSesionComo implements Task {

    private final String email;
    private final String password;

    public IniciarSesionComo(String email, String password) {
        this.email    = email;
        this.password = password;
    }

    public static IniciarSesionComo conCredenciales(String email, String password) {
        return instrumented(IniciarSesionComo.class, email, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(email).into(LoginPage.EMAIL),
                Enter.theValue(password).into(LoginPage.PASSWORD)
        );
    }
}
