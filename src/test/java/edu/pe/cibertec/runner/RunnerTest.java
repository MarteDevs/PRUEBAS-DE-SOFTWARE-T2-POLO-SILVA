package edu.pe.cibertec.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "edu.pe.cibertec.stepdefinitions",
        plugin = {"pretty"},
        tags = "not @ignore"
)
public class RunnerTest {
}