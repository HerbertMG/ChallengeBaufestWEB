package stepdefinitions;

import cucumber.api.java.es.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.selectactions.SelectByIndexFromBy;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import tasks.LoginUsuario;
import tasks.RegistrarUsuario;
import tasks.SeleccionarProducto;
import userinterfaces.HomePageDemoblaze;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static userinterfaces.EcommercePageDemoblaze.PRODUCTO_EN_CARRITO;

public class DemoblazeSteps {


    private Actor actor = Actor.named("ClienteBlaze");
    private HomePageDemoblaze homePageDemoblaze = new HomePageDemoblaze();


    @Dado("^que un nuevo cliente ingresa a la web$")
    public void queUnNuevoClienteIngresaALaWeb() {
        actor.can(BrowseTheWeb.with(getDriver()));
        actor.wasAbleTo(Open.browserOn(homePageDemoblaze));
        getDriver().manage().window().maximize();
    }

    @Dado("^se registre con sus nuevas credenciales usuario (.*) y constraseña (.*)$")
    public void seRegistreConSusNuevasCredencialesUsuarioYContraseña(String user, String pass) {
        actor.wasAbleTo(
                RegistrarUsuario.conDatos(user,pass)
        );
    }

    @Cuando("^se haga login con sus credenciales usuario (.*) y constraseña (.*)$")
    public void seHagaLoginConSusCredencialesUsuarioYConstraseña(String user, String pass) {
        actor.wasAbleTo(
                LoginUsuario.conCredenciales(user,pass)
        );
    }

    @Cuando("^se seleccione un producto al carrito$")
    public void seSeleccioneUnProductoAlCarrito(List<String> detalle) {
        actor.wasAbleTo(
                SeleccionarProducto.conProducto(detalle.get(0), detalle.get(1))
        );
    }

    @Entonces("^en el carrito se muestra los productos agregados$")
    public void enElCarritoSeMuestraLosProductosAgregados(List<String> producto) {
        actor.should(seeThat(the(PRODUCTO_EN_CARRITO.of(producto.get(0))), isPresent()));

    }
}
