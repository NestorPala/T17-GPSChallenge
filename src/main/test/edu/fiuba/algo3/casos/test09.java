package edu.fiuba.algo3.casos;

import edu.fiuba.algo3.modelo.Chocables.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class test09 {
    @Test
    public void test09_UnVehiculoSeEncuentraConUnControlPolicialYPuedeRecibirPenalizacion()
    {
        Escenario escenario = Escenario.getInstance(20, 20);
        Vehiculo moto = new Moto();
        Jugador jugador = new Jugador(moto);
        Chocable controlPolicial = new ControlPolicial();

        escenario.insertarChocable(controlPolicial, new Posicion(1, 2));

        jugador.mover(Direccion.arriba());

        assertTrue((jugador.puntaje() == 1.0 || jugador.puntaje() == 4.0));
    }
}
