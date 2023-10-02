package com.quipux.utils;

import com.quipux.exceptions.GeneralExcepcion;
import com.quipux.userinterfaces.PaginaDatosCita;
import net.serenitybdd.screenplay.targets.Target;

public class ParseProgramaSalud {

    public static Target parse(String programa) {
        Target targetToReturn;
        switch (programa.trim().toLowerCase()) {
            case "medicare":
                targetToReturn = PaginaDatosCita.CHECK_PROGRAM_MEDICARE;
                break;
            case "medicaid":
                targetToReturn = PaginaDatosCita.CHECK_PROGRAM_MEDICAID;
                break;
            case "none":
                targetToReturn = PaginaDatosCita.CHECK_PROGRAM_NONE;
                break;
            default:
                throw new GeneralExcepcion("El programa de salud no existe");
        }
        return targetToReturn;
    }

}
