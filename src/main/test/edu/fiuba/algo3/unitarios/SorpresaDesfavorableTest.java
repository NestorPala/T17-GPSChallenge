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

        sorpresaDesfavorable.devolverEfecto(new Auto());
        assertEquals(puntaje.verMovimientos(), 12.5);

        sorpresaDesfavorable.devolverEfecto(new Moto());
        assertEquals(puntaje.verMovimientos(),15.625);

        sorpresaDesfavorable.devolverEfecto(new Todoterreno());
        assertEquals(puntaje.verMovimientos(), 19.53125);
    }
}
