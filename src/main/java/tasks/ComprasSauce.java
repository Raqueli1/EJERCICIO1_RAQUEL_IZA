package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userinterface.sauceDemoPageInterface;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ComprasSauce implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                WaitUntil.the(sauceDemoPageInterface.PRODUCTO1, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(sauceDemoPageInterface.PRODUCTO1),

                WaitUntil.the(sauceDemoPageInterface.PRODUCTO2, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(sauceDemoPageInterface.PRODUCTO2),

                WaitUntil.the(sauceDemoPageInterface.CARRITO, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(sauceDemoPageInterface.CARRITO),

                WaitUntil.the(sauceDemoPageInterface.BTNcHECKOUT, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(sauceDemoPageInterface.BTNcHECKOUT),

                WaitUntil.the(sauceDemoPageInterface.FIRSTNAME, isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue("Raquel").into(sauceDemoPageInterface.FIRSTNAME),

                WaitUntil.the(sauceDemoPageInterface.LASTNAME, isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue("Iza").into(sauceDemoPageInterface.LASTNAME),

                WaitUntil.the(sauceDemoPageInterface.POSTALCODE, isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue("7777").into(sauceDemoPageInterface.POSTALCODE),

                WaitUntil.the(sauceDemoPageInterface.CONTINUAR, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(sauceDemoPageInterface.CONTINUAR),

                WaitUntil.the(sauceDemoPageInterface.FIN, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(sauceDemoPageInterface.FIN)
        );


    }
    public static ComprasSauce enter()
    {

        return Tasks.instrumented(ComprasSauce.class);
    }
}
