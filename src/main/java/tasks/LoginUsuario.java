package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.HomePageDemoblaze.*;
public class LoginUsuario implements Task {

    private String user;
    private String pass;
    public LoginUsuario(String user, String pass){
        this.user = user;
        this.pass = pass;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LABEL_LOGIN, WebElementStateMatchers.isVisible()).forNoMoreThan(5).seconds(),
                Click.on(LABEL_LOGIN), //Clic en la opción que permite realizar el login
                WaitUntil.the(INPUT_LOGIN_USER, WebElementStateMatchers.isVisible()).forNoMoreThan(5).seconds(), //Espera del efecto fade
                Enter.theValue(user).into(INPUT_LOGIN_USER), //Completar campo de login user
                Enter.theValue(pass).into(INPUT_LOGIN_PASS), //Completar campo de login password
                Hit.the(Keys.ENTER).into(BUTTON_LOGIN), //Finalizar formulario y realizar login
                WaitUntil.the(LABEL_USER.of(user), WebElementStateMatchers.isVisible()).forNoMoreThan(5).seconds()//
        );

    }

    public static LoginUsuario conCredenciales(String user, String pass) {
        return instrumented(LoginUsuario.class,user,pass);
    }
}
