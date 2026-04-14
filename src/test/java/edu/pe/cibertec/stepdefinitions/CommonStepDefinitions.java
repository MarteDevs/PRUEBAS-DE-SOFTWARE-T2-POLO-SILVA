package edu.pe.cibertec.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class CommonStepDefinitions {

    @Before
    public void setUpStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    protected Actor actor() {
        return OnStage.theActorCalled("Usuario");
    }
}
