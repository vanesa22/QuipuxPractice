package com.quipux.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = "com.quipux.steps",
        features = "src/test/resources/features/reservar_cita.feature",
        tags = "@scenario1",
        snippets = SnippetType.CAMELCASE,
        monochrome = true
)

public class ReservarCita {
}
