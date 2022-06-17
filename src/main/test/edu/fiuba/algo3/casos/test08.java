package edu.fiuba.algo3.casos;

import edu.fiuba.algo3.modelo.Chocables.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test08 {
    @Test
    public void test08_UnVehiculoAtraviesaLaCiudadYEncuentraUnaSorpresaCambioDeVehiculo() 
    {
        Escenario escenario = Escenario.getInstance(20, 20);
        Vehiculo auto = new Auto();
        Jugador jugador = new Jugador(auto);
        Chocable sorpresaCambioVehiculo = new SorpresaCambioVehiculo();
        Chocable pozo = new Pozo();

        escenario.insertarChocable(sorpresaCambioVehiculo, new Posicion(1, 0));
        escenario.insertarChocable(pozo, new Posicion(0, 0));

        jugador.mover(Direccion.abajo());
        jugador.mover(Direccion.izquierda());

        assertEquals(2, jugador.puntaje());
    }
}
