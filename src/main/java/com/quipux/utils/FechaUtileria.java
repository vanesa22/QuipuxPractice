package com.quipux.utils;

import com.quipux.exceptions.GeneralExcepcion;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FechaUtileria {

    public static Date parseFromString(String date) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException exception) {
            throw new GeneralExcepcion("El formato de fecha " + date + " es invalido");
        }
    }

    public static String parseFromDate(Date date) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return dateFormat.format(date);
        } catch (NullPointerException | IllegalArgumentException exception) {
            throw new GeneralExcepcion("El formato de fecha " + date.toString() + " es invalido");
        }
    }

}
