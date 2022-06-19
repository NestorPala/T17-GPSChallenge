package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.Chocables.Chocable;
import edu.fiuba.algo3.modelo.Chocables.SorpresaFavorable;
import edu.fiuba.algo3.modelo.Efectos.Efecto;
import edu.fiuba.algo3.modelo.Jugador;
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
        Jugador jugador1 = new Jugador(new Auto());
        jugador1.recibirPenalizacion(10);

        Efecto efecto = sorpresaFavorable.devolverEfecto(new Auto());
        efecto.aplicarEfecto(jugador1);
        assertEquals(jugador1.puntaje(), 8);

        Efecto efecto2 = sorpresaFavorable.devolverEfecto(new Moto());
        efecto2.aplicarEfecto(jugador1);
        assertEquals(jugador1.puntaje(),6.4);

        Efecto efecto3 = sorpresaFavorable.devolverEfecto(new Todoterreno());
        efecto3.aplicarEfecto(jugador1);
        assertEquals(jugador1.puntaje(), 5.12);
    }
}
