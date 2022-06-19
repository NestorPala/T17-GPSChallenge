package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.Chocables.Chocable;
import edu.fiuba.algo3.modelo.Chocables.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.Efectos.Efecto;
import edu.fiuba.algo3.modelo.Jugador;
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
        Jugador jugador1 = new Jugador(new Auto());
        jugador1.recibirPenalizacion(10);

        Efecto efecto = sorpresaDesfavorable.devolverEfecto(new Auto());
        efecto.aplicarEfecto(jugador1);
        assertEquals(jugador1.puntaje(), 12.5);

        Efecto efecto2 = sorpresaDesfavorable.devolverEfecto(new Moto());
        efecto2.aplicarEfecto(jugador1);
        assertEquals(jugador1.puntaje(),15.625);

        Efecto efecto3 = sorpresaDesfavorable.devolverEfecto(new Todoterreno());
        efecto3.aplicarEfecto(jugador1);
        assertEquals(jugador1.puntaje(), 19.53125);
    }
}
