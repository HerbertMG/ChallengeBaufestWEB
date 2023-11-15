package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class Alertas implements Question<String> {


    @Override
    public String answeredBy(Actor actor) {

        WebDriver driver = actor.usingAbilityTo(BrowseTheWeb.class).getDriver();

        Alert alerta = driver.switchTo().alert();

        return alerta.getText();
    }

    public static Alertas mensajeDeAlerta() {
        return new Alertas();
    }
}
