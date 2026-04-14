package edu.pe.cibertec.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

    public static final Target EMAIL =
            Target.the("email field").locatedBy("#input-email");

    public static final Target PASSWORD =
            Target.the("password field").locatedBy("#input-password");

    public static final Target LOGIN_BUTTON =
            Target.the("login button").locatedBy("//input[@value='Login']");

    public static final Target ACCOUNT_LINK =
            Target.the("account dropdown link").locatedBy("#top-links .dropdown-toggle");

    public static final Target ERROR_MESSAGE =
            Target.the("error message").locatedBy(".alert-danger");
}
