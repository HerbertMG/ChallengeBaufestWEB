package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EcommercePageDemoblaze {

    public static final Target SELECT_CATEGORIA = Target.the("Categoria a seleccionar")
            .locatedBy("//a[contains(text(),'{0}')]");
    public static final Target SELECT_PRODUCTO = Target.the("Producto a seleccionar")
            .locatedBy("//a[contains(text(),'{0}')]");
    public static final Target BUTTON_ADDTOCART = Target.the("Boton añadir al carrito")
            .locatedBy("//a[contains(text(),'Add to cart')]");
    public static final Target LABEL_CART = Target.the("Opcion de ir al carrito")
            .located(By.id("cartur"));

    public static final Target PRODUCTO_EN_CARRITO = Target.the("Producto agregado al carrito")
            .locatedBy("//td[contains(text(),'{0}')]");

    public static final Target BUTTON_ORDER = Target.the("Boton de envio")
            .locatedBy("//button[contains(text(),'Place Order')]");
}
