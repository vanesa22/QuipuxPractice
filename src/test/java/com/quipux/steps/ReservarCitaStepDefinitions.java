package com.quipux.steps;

import com.quipux.exceptions.GeneralExcepcion;
import com.quipux.model.DatosCita;
import com.quipux.questions.ValidacionResumenCita;
import com.quipux.tasks.AgregarInformacionCita;
import com.quipux.tasks.IniciarReserva;
import com.quipux.tasks.IniciarSesion;
import com.quipux.userinterfaces.PaginaInicial;
import cucumber.api.java.Before;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class ReservarCitaStepDefinitions {


    @Before
    public void setup() {
        setTheStage(new OnlineCast());
    }

    @Given("^Vanesa esta en la pagina de inicio de Servicios de salud CURA$")
    public void VanesaEstaEnLaPaginaDeInicioDeServiciosDeSaludCURA() {
        theActorCalled("Vanesa").wasAbleTo(Open.browserOn(new PaginaInicial()));

    }

    @Given("^Vanesa haga click en el boton Reserva cita medica$")
    public void vanesaHagaClickEnElBotonReservaCitaMedica() {
        theActorInTheSpotlight().attemptsTo(
                IniciarReserva.IniciarReserva()
        );
    }

    @When("^Ella inicia sesion con (.*) y (.*)$")
    public void ellaIniciaSesion(String usuario, String contrasena) {
        theActorInTheSpotlight().attemptsTo(IniciarSesion.IngresarDatosInicioSesion(usuario, contrasena));
    }

    @When("^Ella registra los siguientes datos de la reserva$")
    public void ellaRegistraLosSiguientesDatosDeLaReserva(List<DatosCita> datosCita) throws GeneralExcepcion {
        theActorInTheSpotlight().attemptsTo(AgregarInformacionCita.AgregarInformacionCita(
                datosCita.get(0)
        ));
    }

    @Then("^deberia ver un mensaje con el resumen y confirmacion de la cita medica$")
    public void deberiaVerUnMensajeConElResumenYConfirmacionDeLaCitaMedica() {
        theActorInTheSpotlight().should(seeThat(ValidacionResumenCita.resumenEsCorrecto()).orComplainWith(GeneralExcepcion.class, "La informacion del resumen de la cita no son correctos"));
    }




}
