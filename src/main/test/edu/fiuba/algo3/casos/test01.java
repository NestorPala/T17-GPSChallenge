package edu.fiuba.algo3.casos;

import edu.fiuba.algo3.modelo.Chocables.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test01 {    @Test
    public void test01_motoChocaPozoYEsPenalizadaConTresMovimientos()
    {
        Escenario escenario = Escenario.getInstance();
        Vehiculo moto = new Moto();
        Jugador jugador = new Jugador(moto);
        Chocable pozo = new Pozo();

        escenario.insertarChocable(pozo, new Posicion(2, 1));

        jugador.mover(Direccion.derecha());

        assertEquals(4, jugador.puntaje());
    }
    
}
