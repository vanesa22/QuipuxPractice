package com.quipux.userinterfaces;


import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;


public class PaginaLogin {
    public static final Target INPUT_USERNAME = Target.the("Donde escribimos el nombre del usuario").located(By.id("txt-username"));
    public static final Target INPUT_PASSWORD = Target.the("Donde escribimos la contraseña").located(By.id("txt-password"));
    public static final Target BUTTON_LOGIN = Target.the("Boton para iniciar sesion").located(By.id("btn-login"));

}
