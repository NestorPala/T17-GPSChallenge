package edu.fiuba.algo3.unitarios.EscenarioTests;

import edu.fiuba.algo3.modelo.Chocables.Pozo;
import edu.fiuba.algo3.modelo.Escenario;
import edu.fiuba.algo3.modelo.TamañoDelEscenarioInvalido;
import edu.fiuba.algo3.modelo.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EscenarioTest_02 {

    @Test
    public void noSePuedeColocarUnChocableFueraDeLosLimitesDelEscenario() 
    throws TamañoDelEscenarioInvalido
    {
        Escenario escenario = Escenario.getInstance();
        Pozo pozo = new Pozo();

        escenario.insertarChocable(pozo, new Posicion(11, 11));
        assertNull(escenario.obtenerChocable(new Posicion(11, 11)));
    }
    
}
