package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.Chocables.Pozo;
import edu.fiuba.algo3.modelo.Escenario;
import edu.fiuba.algo3.modelo.TamañoDelEscenarioInvalido;
import edu.fiuba.algo3.modelo.Posicion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class EscenarioTest {

    @Test
    public void noSePuedeCrearUnEscenarioConUnTamanioInvalido() {
        Executable tarea1 = () -> new Escenario(-5, 5);
        assertThrows(TamañoDelEscenarioInvalido.class, tarea1);

        Executable tarea2 = () -> new Escenario(5, -5);
        assertThrows(TamañoDelEscenarioInvalido.class, tarea2);
    }

    @Test
    public void noSePuedeColocarUnChocableFueraDeLosLimitesDelEscenario() 
    throws TamañoDelEscenarioInvalido
    {
        Escenario escenario = new Escenario(10, 10);
        Pozo pozo = new Pozo();

        escenario.insertarChocable(pozo, new Posicion(11, 11));
        assertNull(escenario.obtenerChocable(new Posicion(11, 11)));
    }

    @Test
    public void noSePuedeObtenerUnChocableDeUnLugarFueraDeLosLimitesDelEscenario(){
         Escenario escenario = new Escenario(10, 10);

        assertNull(escenario.obtenerChocable(new Posicion(11, 11)));
    }

    @Test
    public void SiChequeoUnElementoFueraDelEscenarioObtengoUnaRespuestaCorrecta(){
        Escenario escenario = new Escenario(10,10);

        assertFalse(escenario.estaDentroDelEscenario(new Posicion(11,5)));
        assertFalse(escenario.estaDentroDelEscenario(new Posicion(-5,5)));
        assertFalse(escenario.estaDentroDelEscenario(new Posicion(5, 11)));
        assertFalse(escenario.estaDentroDelEscenario(new Posicion(5,-5)));
    }
}
