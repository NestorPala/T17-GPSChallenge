package edu.fiuba.algo3.casos;

import edu.fiuba.algo3.modelo.Chocables.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test05 {
    @Test
    public void test05_todoterrenoChocaConTresPozosYEsPenalizadoConDosMovimientos()
    {
        Escenario escenario = Escenario.getInstance(20, 20);
        Vehiculo todoterreno = new Todoterreno();
        Jugador jugador = new Jugador(todoterreno);
        Chocable pozo = new Pozo();

        // Pongo los pozos
        escenario.insertarChocable(pozo, new Posicion(2, 1));
        escenario.insertarChocable(pozo, new Posicion(3, 1));
        escenario.insertarChocable(pozo, new Posicion(4, 1));

        // Muevo tres veces al jugador
        jugador.mover(Direccion.derecha());
        jugador.mover(Direccion.derecha());
        jugador.mover(Direccion.derecha());

        assertEquals(5, jugador.puntaje());
    }
}
