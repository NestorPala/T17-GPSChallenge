package edu.fiuba.algo3.casos;

import edu.fiuba.algo3.modelo.Chocables.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test02 {
    @Test
    public void test02_autoChocaPozoYEsPenalizadoConTresMovimientos()
    {
        Escenario escenario = Escenario.getInstance(20, 20);
        Vehiculo auto = new Auto();
        Jugador jugador = new Jugador(auto);
        Chocable pozo = new Pozo();

        escenario.insertarChocable(pozo, new Posicion(2, 1));

        jugador.mover(Direccion.derecha());

        assertEquals(4, jugador.puntaje());
    }
}
