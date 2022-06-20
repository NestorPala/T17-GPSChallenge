package edu.fiuba.algo3.casos;

import edu.fiuba.algo3.modelo.Chocables.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class test09 {
    @Test
    public void test09_UnVehiculoSeEncuentraConUnControlPolicialYRecibePenalizacion()
    {
        Escenario escenario = Escenario.getInstance();
        Vehiculo moto = new Moto();
        Jugador jugador = new Jugador(moto);
        Randomizer randomizerMock = mock(Randomizer.class);
        when(randomizerMock.aplicar(anyDouble())).thenReturn(true);
        Chocable controlPolicial = new ControlPolicial(randomizerMock);

        escenario.insertarChocable(controlPolicial, new Posicion(1, 2));

        jugador.mover(Direccion.arriba());

        assertEquals(4, jugador.puntaje());
    }

    @Test
    public void test09_UnVehiculoSeEncuentraConUnControlPolicialYNoRecibePenalizacion(){
        Escenario escenario = Escenario.getInstance();
        Vehiculo moto = new Moto();
        Jugador jugador = new Jugador(moto);
        Randomizer randomizerMock = mock(Randomizer.class);
        when(randomizerMock.aplicar(anyDouble())).thenReturn(false);
        Chocable controlPolicial = new ControlPolicial(randomizerMock);

        escenario.insertarChocable(controlPolicial, new Posicion(1,2));

        jugador.mover(Direccion.arriba());

        assertEquals(1, jugador.puntaje());
    }
}
