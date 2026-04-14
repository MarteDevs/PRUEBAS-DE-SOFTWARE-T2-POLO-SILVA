package edu.pe.cibertec.screenplay.questions;

import edu.pe.cibertec.screenplay.ui.CarritoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

@Subject("el contador del carrito")
public class ContadorDelCarrito implements Question<String> {

    public static ContadorDelCarrito actual() {
        return new ContadorDelCarrito();
    }

    @Override
    public String answeredBy(Actor actor) {
        /*
         * Después de "Add to Cart", OpenCart hace AJAX y actualiza #cart-total.
         * El texto cambia de "0 item(s) - $0.00" a "1 item(s) - $123.20".
         *
         * Usamos un retry manual hasta 10 segundos esperando que
         * el texto contenga "item(s)" con un número > 0.
         */
        String cartText = "";
        int attempts = 0;
        int maxAttempts = 20; // 20 × 500ms = 10 segundos

        while (attempts < maxAttempts) {
            cartText = CarritoPage.CART_TOTAL
                    .resolveFor(actor)
                    .getText()
                    .trim();

            // Si ya no es "0 item(s)", el AJAX completó
            if (!cartText.startsWith("0 item")) {
                break;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
            attempts++;
        }

        // Texto ejemplo: "1 item(s) - $123.20" → retorna "1 item(s)"
        if (cartText.contains(" - ")) {
            return cartText.split(" - ")[0].trim();
        }
        return cartText;
    }
}
