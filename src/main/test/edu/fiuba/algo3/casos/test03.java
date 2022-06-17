package edu.fiuba.algo3.casos;

import edu.fiuba.algo3.modelo.Chocables.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test03 {
    @Test
    public void test03_todoterrenoChocaPozoYNoEsPenalizado()
    {
        Escenario escenario = Escenario.getInstance(20, 20);
        Vehiculo todoterreno = new Todoterreno();
        Jugador jugador = new Jugador(todoterreno);
        Chocable pozo = new Pozo();

        escenario.insertarChocable(pozo, new Posicion(2, 1));

        jugador.mover(Direccion.derecha());

        assertEquals(1, jugador.puntaje());
    }
}
