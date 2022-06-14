package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.Chocables.Chocable;
import edu.fiuba.algo3.modelo.Chocables.ControlPolicial;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControlPolicialTest {
    @Test
    public void puedoObtenerLosPuntosDePenalizacionCorrectosPorCadaVehiculo() {
        Chocable controlPolicial = new ControlPolicial();
        Puntaje puntaje = new Puntaje();

        controlPolicial.aplicarPenalizacion(new Auto(), puntaje);
        assertTrue(puntaje.verMovimientos() == 0 || puntaje.verMovimientos() == 3);

        puntaje = new Puntaje();
        controlPolicial.aplicarPenalizacion(new Moto(), puntaje);
        assertTrue(puntaje.verMovimientos() == 0 || puntaje.verMovimientos() == 3);

        puntaje = new Puntaje();
        controlPolicial.aplicarPenalizacion(new Todoterreno(), puntaje);
        assertTrue(puntaje.verMovimientos() == 0 || puntaje.verMovimientos() == 3);
    }
}
