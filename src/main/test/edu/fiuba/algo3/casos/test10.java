package edu.fiuba.algo3.casos;

import edu.fiuba.algo3.modelo.Chocables.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test10 {
    // Idea: considerar sorpresa y obstaculo a la vez
    @Test
    public void test10_UnTodoterrenoChocaConUnaSorpresaCambioDeVehiculoYLuegoChocaConUnPiquete()
    {
        Escenario escenario = Escenario.getInstance();
        Vehiculo todoterreno = new Todoterreno();
        Jugador jugador = new Jugador(todoterreno);
        Chocable sorpresaCambioVehiculo = new SorpresaCambioVehiculo();
        Chocable piquete = new Piquete();

        escenario.insertarChocable(sorpresaCambioVehiculo, new Posicion(1, 2));
        escenario.insertarChocable(piquete, new Posicion(1, 3));

        jugador.mover(Direccion.arriba());
        jugador.mover(Direccion.arriba());

        assertEquals(4, jugador.puntaje());
    }
}
