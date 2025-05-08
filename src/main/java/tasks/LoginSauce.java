package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userinterface.sauceDemoPageInterface;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginSauce implements Task {
    private String usuario;
    private String contrasena;


    public LoginSauce(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(sauceDemoPageInterface.TXT_USER, isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(usuario).into(sauceDemoPageInterface.TXT_USER),
                WaitUntil.the(sauceDemoPageInterface.TXT_PASS, isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(contrasena).into(sauceDemoPageInterface.TXT_PASS),
                WaitUntil.the(sauceDemoPageInterface.BTN_INGRESAR, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(sauceDemoPageInterface.BTN_INGRESAR)
        );
    }
    public static LoginSauce enter(String usuario, String contrasena) {
        return Tasks.instrumented(LoginSauce.class, usuario, contrasena);
    }
}
