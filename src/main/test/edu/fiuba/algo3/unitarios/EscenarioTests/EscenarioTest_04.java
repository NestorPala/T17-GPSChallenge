package edu.fiuba.algo3.unitarios.EscenarioTests;

import edu.fiuba.algo3.modelo.Escenario;
import edu.fiuba.algo3.modelo.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EscenarioTest_04 {

    @Test
    public void SiChequeoUnElementoFueraDelEscenarioObtengoUnaRespuestaCorrecta(){
        Escenario escenario = Escenario.getInstance();

        assertFalse(escenario.estaDentroDelEscenario(new Posicion(11,5)));
        assertFalse(escenario.estaDentroDelEscenario(new Posicion(-5,5)));
        assertFalse(escenario.estaDentroDelEscenario(new Posicion(5, 11)));
        assertFalse(escenario.estaDentroDelEscenario(new Posicion(5,-5)));
    }
    
}
