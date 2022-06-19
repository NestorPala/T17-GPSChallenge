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

        sorpresaFavorable.devolverEfecto(new Auto());
        assertEquals(puntaje.verMovimientos(), 8);

        sorpresaFavorable.devolverEfecto(new Moto());
        assertEquals(puntaje.verMovimientos(),6.4);

        sorpresaFavorable.devolverEfecto(new Todoterreno());
        assertEquals(puntaje.verMovimientos(), 5.12);
    }
}
