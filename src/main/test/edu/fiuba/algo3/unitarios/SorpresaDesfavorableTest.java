package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.Chocables.Chocable;
import edu.fiuba.algo3.modelo.Chocables.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SorpresaDesfavorableTest {
    @Test
    public void puedoObtenerLosPuntosDePenalizacionCorrectosPorCadaVehiculo(){
        Chocable sorpresaDesfavorable = new SorpresaDesfavorable();
        Puntaje puntaje = new Puntaje();

        puntaje.sumarMovimientos(10);

        sorpresaDesfavorable.aplicarPenalizacion(new Auto(), puntaje);
        assertEquals(puntaje.verMovimientos(), 12.5);

        sorpresaDesfavorable.aplicarPenalizacion(new Moto(), puntaje);
        assertEquals(puntaje.verMovimientos(),15.625);

        sorpresaDesfavorable.aplicarPenalizacion(new Todoterreno(), puntaje);
        assertEquals(puntaje.verMovimientos(), 19.53125);
    }
}
