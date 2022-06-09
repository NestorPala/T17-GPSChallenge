package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.Chocables.Vacio;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VacioTest {
    @Test
    public void LosPuntosDePenalizacionPorChocarConUnVacioSonCero(){
        Vacio vacio = new Vacio();

        assertEquals(vacio.obtenerPuntosDePenalizacion(new Auto()), 0);
        assertEquals(vacio.obtenerPuntosDePenalizacion(new Moto()), 0);
        assertEquals(vacio.obtenerPuntosDePenalizacion(new Todoterreno()), 0);
    }
}
