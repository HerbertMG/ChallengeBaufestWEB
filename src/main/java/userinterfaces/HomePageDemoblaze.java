package userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("page:webdriver.base.url")
public class HomePageDemoblaze extends PageObject {

    //-----------ELEMENTOS PARA EL REGISTRO----------------//
    public static final Target LABEL_REGISTRO = Target.the("Ubica label donde se muestre el formulario de REGISTRO")
            .located(By.id("signin2"));
    public static final Target INPUT_SIGN_USER = Target.the("Input donde se ingresa el nuevo USER")
            .located(By.id("sign-username"));
    public static final Target INPUT_SIGN_PASS = Target.the("Input donde se ingresa el PASSWORD")
            .located(By.id("sign-password"));
    public static final Target BUTTON_SIGNUP = Target.the("Button que registra el nuevo usuario")
            .locatedBy("//button[contains(text(),'Sign up')]");
    public static final Target BUTTON_CLOSE = Target.the("Button que cierra el registro")
            .locatedBy("//button[contains(text(),'Close')]");
    //-----------ELEMENTOS PARA EL REGISTRO----------------//

    //-----------ELEMENTOS PARA EL LOGIN----------------//
    public static final Target LABEL_LOGIN = Target.the("Ubica label donde se muestre el formulario de LOGIN")
            .located(By.id("login2"));
    public static final Target INPUT_LOGIN_USER = Target.the("Input de logeo donde se ingresa el USER")
            .located(By.id("loginusername"));
    public static final Target INPUT_LOGIN_PASS = Target.the("Input de logeo donde se ingresa el PASSWORD")
            .located(By.id("loginpassword"));
    public static final Target BUTTON_LOGIN = Target.the("Button que logea al usuario")
            .locatedBy("//button[contains(text(),'Log in')]");
    public static final Target LABEL_USER = Target.the("Ubica label donde muestre USUARIO logeado")
            .locatedBy("//a[contains(text(),'Welcome {0}')]");
    //-----------ELEMENTOS PARA EL LOGIN----------------//


}
