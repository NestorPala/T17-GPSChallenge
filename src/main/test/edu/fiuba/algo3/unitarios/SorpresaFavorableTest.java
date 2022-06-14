package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.Chocables.Chocable;
import edu.fiuba.algo3.modelo.Chocables.SorpresaFavorable;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SorpresaFavorableTest {
    @Test
    public void puedoObtenerLosPuntosDePenalizacionCorrectosPorCadaVehiculo(){
        Chocable sorpresaFavorable = new SorpresaFavorable();
        Puntaje puntaje = new Puntaje();

        puntaje.sumarMovimientos(10);

        sorpresaFavorable.aplicarPenalizacion(new Auto(), puntaje);
        assertEquals(puntaje.verMovimientos(), 8);

        sorpresaFavorable.aplicarPenalizacion(new Moto(), puntaje);
        assertEquals(puntaje.verMovimientos(),6.4);

        sorpresaFavorable.aplicarPenalizacion(new Todoterreno(), puntaje);
        assertEquals(puntaje.verMovimientos(), 5.12);
    }
}
