package com.quipux.tasks;

import com.quipux.userinterfaces.PaginaLogin;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class IniciarSesion implements Task {

    private String usuario;
    private String contrasena;

    public IniciarSesion(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public static IniciarSesion IngresarDatosInicioSesion(String parUsuario, String parContrasena) {
        return Tasks.instrumented(IniciarSesion.class, parUsuario, parContrasena);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(usuario).into(PaginaLogin.INPUT_USERNAME),
                Enter.theValue(contrasena).into(PaginaLogin.INPUT_PASSWORD),
                Click.on(PaginaLogin.BUTTON_LOGIN)
        );
    }

}
