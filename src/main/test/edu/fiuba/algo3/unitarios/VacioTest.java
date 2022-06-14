package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.Chocables.Chocable;
import edu.fiuba.algo3.modelo.Chocables.Vacio;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VacioTest {
    @Test
    public void LosPuntosDePenalizacionPorChocarConUnVacioSonCero(){
        Chocable vacio = new Vacio();
        Puntaje puntaje = new Puntaje();

        vacio.aplicarPenalizacion(new Auto(), puntaje);
        assertEquals(puntaje.verMovimientos(), 0);

        vacio.aplicarPenalizacion(new Moto(), puntaje);
        assertEquals(puntaje.verMovimientos(),0);

        vacio.aplicarPenalizacion(new Todoterreno(), puntaje);
        assertEquals(puntaje.verMovimientos(), 0);
    }
}