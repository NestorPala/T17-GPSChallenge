package edu.fiuba.algo3.unit.chocables;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.model.Puntaje;
import edu.fiuba.algo3.model.Chocables.Chocable;
import edu.fiuba.algo3.model.Chocables.Vacio;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import edu.fiuba.algo3.model.Vehiculos.Todoterreno;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VacioTest {

    @Test
    public void test01_LosPuntosDePenalizacionPorChocarConUnVacioSonCero(){
        Chocable vacio = new Vacio();
        Puntaje puntaje = new Puntaje();

        vacio.devolverEfecto(new Auto());
        assertEquals(puntaje.verMovimientos(), 0);

        vacio.devolverEfecto(new Moto());
        assertEquals(puntaje.verMovimientos(),0);

        vacio.devolverEfecto(new Todoterreno());
        assertEquals(puntaje.verMovimientos(), 0);
    }
    
}
