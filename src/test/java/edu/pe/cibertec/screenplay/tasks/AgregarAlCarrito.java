package edu.pe.cibertec.screenplay.tasks;

import edu.pe.cibertec.screenplay.ui.BusquedaPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AgregarAlCarrito implements Task {

    private final String producto;

    public AgregarAlCarrito(String producto) {
        this.producto = producto;
    }

    public static AgregarAlCarrito elProducto(String producto) {
        return instrumented(AgregarAlCarrito.class, producto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // 1. Buscar el producto por nombre en el buscador del header
        actor.attemptsTo(
                Enter.theValue(producto).into(BusquedaPage.SEARCH_INPUT),
                Click.on(BusquedaPage.SEARCH_BUTTON)
        );

        Target addToCartBtn = Target.the("add to cart for " + producto)
                .locatedBy("//h4[a[contains(text(),'" + producto + "')]]"
                         + "/../following-sibling::div[@class='button-group']/button[1]");

        // 2. Hacer clic en Agregar al carrito
        actor.attemptsTo(
                Click.on(addToCartBtn)
        );
    }
}
