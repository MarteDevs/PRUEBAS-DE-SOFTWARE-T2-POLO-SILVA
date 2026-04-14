package edu.pe.cibertec.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

public class RegistroPage {
    public static final Target FIRSTNAME =
            Target.the("firstname field").locatedBy("#input-firstname");

    public static final Target LASTNAME =
            Target.the("lastname field").locatedBy("#input-lastname");

    public static final Target EMAIL =
            Target.the("email field").locatedBy("#input-email");

    public static final Target TELEPHONE =
            Target.the("telephone field").locatedBy("#input-telephone");

    public static final Target PASSWORD =
            Target.the("password field").locatedBy("#input-password");

    public static final Target CONFIRM_PASSWORD =
            Target.the("confirm password field").locatedBy("#input-confirm");

    public static final Target AGREE_CHECKBOX =
            Target.the("agree checkbox").locatedBy("//input[@name='agree']");

    public static final Target CONTINUE_BUTTON =
            Target.the("continue button").locatedBy("//input[@value='Continue']");

    public static final Target SUCCESS_MESSAGE =
            Target.the("success message heading").locatedBy("#content h1");
}
