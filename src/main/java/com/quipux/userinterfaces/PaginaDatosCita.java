package com.quipux.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaDatosCita {


    public static final Target SELECT_FACILITY = Target.the("Donde seleccionamos el centro de atencion").located(By.id("combo_facility"));
    public static final Target CHECK_READMISSION = Target.the("Donde seleccionamos la solicitud de una readmision hospitalaria").located(By.id("chk_hospotal_readmission"));
    public static final Target CHECK_PROGRAM_MEDICARE= Target.the("Donde seleccionamos programa de salud , seguro del estado medico").located(By.id("radio_program_medicare"));
    public static final Target CHECK_PROGRAM_MEDICAID= Target.the("Donde seleccionamos programa de salud , seguro del estado medico").located(By.id("radio_program_medicaid"));
    public static final Target CHECK_PROGRAM_NONE= Target.the("Donde seleccionamos programa de salud , seguro del estado medico").located(By.id("radio_program_none"));
    public static final Target INPUT_VISIT_DATE = Target.the("Donde escribimos la fecha de la cita").located(By.id("txt_visit_date"));
    public static final Target INPUT_COMMENT = Target.the("Donde escribimos comentarios respecto a la cita").located(By.id("txt_comment"));
    public static final Target BUTTON_BOOK_APPOINTMENT = Target.the("Boton para confirmar la cita reservada").located(By.id("btn-book-appointment"));

}
