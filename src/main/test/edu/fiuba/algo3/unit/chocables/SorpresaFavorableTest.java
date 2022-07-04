package edu.fiuba.algo3.unit.chocables;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.model.Chocables.Chocable;
import edu.fiuba.algo3.model.Chocables.SorpresaFavorable;
import edu.fiuba.algo3.model.Efectos.IEfecto;
import edu.fiuba.algo3.model.Jugador.Jugador;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import edu.fiuba.algo3.model.Vehiculos.Todoterreno;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SorpresaFavorableTest {

    @Test
    public void test01_puedoObtenerLosPuntosDePenalizacionCorrectosPorCadaVehiculo(){
        Chocable sorpresaFavorable = new SorpresaFavorable();
        Jugador jugador1 = new Jugador(new Auto(), "Juan");
        jugador1.recibirPenalizacion(10);

        IEfecto efecto = sorpresaFavorable.devolverEfecto(new Auto());
        efecto.aplicarEfecto(jugador1);
        assertEquals(jugador1.puntaje(), 8);

        IEfecto efecto2 = sorpresaFavorable.devolverEfecto(new Moto());
        efecto2.aplicarEfecto(jugador1);
        assertEquals(jugador1.puntaje(), 6.4);

        IEfecto efecto3 = sorpresaFavorable.devolverEfecto(new Todoterreno());
        efecto3.aplicarEfecto(jugador1);
        assertEquals(jugador1.puntaje(), 5.12);
    }
    
}
