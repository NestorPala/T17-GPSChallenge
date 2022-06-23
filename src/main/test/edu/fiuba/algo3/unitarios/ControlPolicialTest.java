package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.Chocables.Chocable;
import edu.fiuba.algo3.modelo.Chocables.ControlPolicial;
import edu.fiuba.algo3.modelo.Chocables.Randomizer;
import edu.fiuba.algo3.modelo.Efectos.IEfecto;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.*;

public class ControlPolicialTest {

    @Test
    public void puedoObtenerLosPuntosDePenalizacionCorrectosSiSeAplicaLaProbabilidad(){
        Randomizer randomMock = mock(Randomizer.class);
        when(randomMock.aplicar(anyDouble())).thenReturn(true);

        Chocable controlPolicial = new ControlPolicial(randomMock);
        Jugador jugador1 = new Jugador(new Auto(), "Juan");

        IEfecto efecto = controlPolicial.devolverEfecto(new Auto());
        efecto.aplicarEfecto(jugador1);
        assertEquals(jugador1.puntaje(), 3);

        IEfecto efecto2 = controlPolicial.devolverEfecto(new Moto());
        efecto2.aplicarEfecto(jugador1);
        assertEquals(jugador1.puntaje(),6);

        IEfecto efecto3 = controlPolicial.devolverEfecto(new Todoterreno());
        efecto3.aplicarEfecto(jugador1);
        assertEquals(jugador1.puntaje(), 9);
    }

    @Test
    public void puedoObtenerLosPuntosDePenalizacionCorrectosSiNoSeAplicaLaProbabilidad(){
        Randomizer randomMock = mock(Randomizer.class);
        when(randomMock.aplicar(anyDouble())).thenReturn(false);

        Chocable controlPolicial = new ControlPolicial(randomMock);
        Jugador jugador1 = new Jugador(new Auto(), "Juan");

        IEfecto efecto = controlPolicial.devolverEfecto(new Auto());
        efecto.aplicarEfecto(jugador1);
        assertEquals(jugador1.puntaje(), 0);

        IEfecto efecto2 = controlPolicial.devolverEfecto(new Moto());
        efecto2.aplicarEfecto(jugador1);
        assertEquals(jugador1.puntaje(),0);

        IEfecto efecto3 = controlPolicial.devolverEfecto(new Todoterreno());
        efecto3.aplicarEfecto(jugador1);
        assertEquals(jugador1.puntaje(), 0);
    }
}