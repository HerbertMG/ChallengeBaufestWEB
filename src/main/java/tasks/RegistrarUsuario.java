package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import questions.Alertas;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.UnhandledAlertException;


import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.HomePageDemoblaze.*;

public class RegistrarUsuario implements Task {

    private String user;
    private String pass;

    public RegistrarUsuario(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    Click.on(LABEL_REGISTRO), //Clic en la opción que permite realizar el registro
                    WaitUntil.the(INPUT_SIGN_USER, WebElementStateMatchers.isVisible()).forNoMoreThan(5).seconds(), //Espera del efecto fade
                    Enter.theValue(user).into(INPUT_SIGN_USER), //Completar campo de user
                    Enter.theValue(pass).into(INPUT_SIGN_PASS), //Completar campo de password
                    Hit.the(Keys.ENTER).into(BUTTON_SIGNUP)//Finalizar formulario y realizar registro
            );

            WebDriverWait wait = new WebDriverWait(actor.usingAbilityTo(BrowseTheWeb.class).getDriver(), 10);
            wait.until(ExpectedConditions.alertIsPresent());
        } catch (UnhandledAlertException e) {

            String mensajeAlerta = actor.asksFor(Alertas.mensajeDeAlerta());

            if (mensajeAlerta.equals("Sign up successful.")) {
                manejarAlertaConEscape(actor);

            } else if (mensajeAlerta.equals("This user already exist.")) {
                manejarAlertaConEscape(actor);
                actor.attemptsTo(
                        WaitUntil.the(BUTTON_SIGNUP, WebElementStateMatchers.isVisible()).forNoMoreThan(5).seconds(),
                        Hit.the(Keys.ESCAPE).into(BUTTON_SIGNUP)//Finalizar formulario
                );
            }
        }

    }

    public static RegistrarUsuario conDatos(String user, String pass) {
        return instrumented(RegistrarUsuario.class, user, pass);
    }

    private void manejarAlertaConEscape(Actor actor) {
        Actions actions = new Actions(actor.usingAbilityTo(BrowseTheWeb.class).getDriver());
        actions.sendKeys(Keys.ESCAPE).perform();
    }

}
