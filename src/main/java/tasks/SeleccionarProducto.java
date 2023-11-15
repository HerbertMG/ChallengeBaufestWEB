package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.EcommercePageDemoblaze.*;


public class SeleccionarProducto implements Task {

    private String categoria;
    private String producto;

    public SeleccionarProducto(String categoria, String producto) {
        this.categoria = categoria;
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    Click.on(SELECT_CATEGORIA.of(categoria)), // Selecciona categoria
                    WaitUntil.the(SELECT_PRODUCTO.of(producto), WebElementStateMatchers.isVisible()).forNoMoreThan(5).seconds(), //Esperamos que se muestre el producto
                    Click.on(SELECT_PRODUCTO.of(producto)), //Selecciona el producto
                    WaitUntil.the(BUTTON_ADDTOCART, WebElementStateMatchers.isVisible()).forNoMoreThan(5).seconds(), //Esperamos que se muestre el boton para agregar al carrito
                    Click.on(BUTTON_ADDTOCART)// Agregamos al carrito
                    //popup
            );
            WebDriverWait wait = new WebDriverWait(actor.usingAbilityTo(BrowseTheWeb.class).getDriver(), 10);
            wait.until(ExpectedConditions.alertIsPresent());
        }
        catch (UnhandledAlertException e) {
            Actions actions = new Actions(actor.usingAbilityTo(BrowseTheWeb.class).getDriver());
            actions.sendKeys(Keys.ESCAPE).perform();
        }

        actor.attemptsTo(
                Click.on(LABEL_CART), // Muestra el carrito de compras
                WaitUntil.the(BUTTON_ORDER, WebElementStateMatchers.isVisible()).forNoMoreThan(5).seconds() //Esperamos que cargue el carrito de compras
        );
    }

    public static SeleccionarProducto conProducto(String categoria, String producto) {
        return instrumented(SeleccionarProducto.class, categoria, producto);
    }

}
