package com.quipux.tasks;

import com.quipux.userinterfaces.PaginaInicial;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class IniciarReserva implements Task {
    public static IniciarReserva IniciarReserva() {
        return Tasks.instrumented(IniciarReserva.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaginaInicial.BUTTON_MAKE_APPOINTMENT)
        );


    }
}
