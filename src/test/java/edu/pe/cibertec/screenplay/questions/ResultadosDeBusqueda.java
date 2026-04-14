package edu.pe.cibertec.screenplay.questions;

import edu.pe.cibertec.screenplay.ui.BusquedaPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import java.util.List;
import java.util.stream.Collectors;

@Subject("los resultados de búsqueda")
public class ResultadosDeBusqueda implements Question<List<String>> {

    public static ResultadosDeBusqueda displayed() {
        return new ResultadosDeBusqueda();
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        return BusquedaPage.PRODUCT_NAMES
                .resolveAllFor(actor)
                .stream()
                .map(element -> element.getText().trim())
                .collect(Collectors.toList());
    }
}
