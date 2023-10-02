package com.quipux.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://katalon-demo-cura.herokuapp.com/")
public class PaginaInicial extends PageObject {
    public static final Target BUTTON_MAKE_APPOINTMENT = Target.the("Boton para confirmar una cita").located(By.id("btn-make-appointment"));

}
