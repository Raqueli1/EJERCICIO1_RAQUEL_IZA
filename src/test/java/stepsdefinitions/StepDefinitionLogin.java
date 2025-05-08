package stepsdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import questions.ClaseAssertText;
import tasks.LoginSauce;
import tasks.ComprasSauce;

import java.util.List;

public class StepDefinitionLogin {

    @Managed /*defino que driver voy a utilizar*/
    WebDriver hisBrowser;

    @Before
    public void setUp(){
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("User");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(hisBrowser));
    }

     String user="";
    String pass="";

    @Given("El usuario ingresa al sitio web de la tienda saucedemo")
    public void UsuarioIngresaALaPaginaWeb() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://www.saucedemo.com/ "));
    }

    @When("ingresa credenciales válidas en los campos de usuario y contraseña")
    public void UsuarioIngresaCredencialesCorrectas(DataTable userInfo) {
        List<List<String>> rows = userInfo.asLists(String.class);
        for(List<String> columns:rows){
            user=columns.get(0);
            pass=columns.get(1);
        }
        OnStage.theActorInTheSpotlight().attemptsTo(LoginSauce.enter(user, pass));
        OnStage.theActorInTheSpotlight().attemptsTo(ComprasSauce.enter());
    }

    @Then("el usuario accede a la página principal y continúa con la compra de dos productos")
    public void UsuarioIngresaAPaginaPrincipalComprar() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ClaseAssertText.esIgual(), Matchers.is("Thank you for your order!")));
    }


}
