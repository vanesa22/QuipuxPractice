package com.quipux.tasks;

import com.quipux.exceptions.GeneralExcepcion;
import com.quipux.model.DatosCita;
import com.quipux.userinterfaces.PaginaDatosCita;
import com.quipux.utils.FechaUtileria;
import com.quipux.utils.ParseProgramaSalud;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import java.time.Instant;
import java.util.Date;

public class AgregarInformacionCita implements Task {


    private DatosCita datosCita;

    public AgregarInformacionCita(DatosCita datosCita) {
        this.datosCita = datosCita;
    }

    public static AgregarInformacionCita AgregarInformacionCita(DatosCita parDatosCita) {
        return Tasks.instrumented(AgregarInformacionCita.class, parDatosCita);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Date currentDate = Date.from(Instant.now());
        if (FechaUtileria.parseFromString(datosCita.getAtrFechaCita()).after(currentDate)) {
            if (datosCita.isAtrReadmision()) {
                actor.attemptsTo(Click.on(PaginaDatosCita.CHECK_READMISSION));
            }
            actor.attemptsTo(
                    SelectFromOptions.byVisibleText(datosCita.getAtrCentroSalud()).from(PaginaDatosCita.SELECT_FACILITY),
                    Click.on(ParseProgramaSalud.parse(datosCita.getAtrProgramaSalud())),
                    Enter.theValue(datosCita.getAtrFechaCita()).into(PaginaDatosCita.INPUT_VISIT_DATE),
                    Enter.theValue(datosCita.getAtrComentario()).into(PaginaDatosCita.INPUT_COMMENT),
                    Click.on(PaginaDatosCita.BUTTON_BOOK_APPOINTMENT)
            );
            actor.remember("datos_cita", datosCita);
        } else {
            throw new GeneralExcepcion("La fecha de la cita no debe ser menor a la actual");
        }
    }


}

