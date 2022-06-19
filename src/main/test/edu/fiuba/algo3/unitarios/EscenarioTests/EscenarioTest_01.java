package edu.fiuba.algo3.unitarios.EscenarioTests;

import edu.fiuba.algo3.modelo.Escenario;
import edu.fiuba.algo3.modelo.TamañoDelEscenarioInvalido;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class EscenarioTest_01 {

    @Test
    public void noSePuedeCrearUnEscenarioConUnTamanioInvalido() {
        Executable tarea1 = () -> Escenario.getInstance();
        assertThrows(TamañoDelEscenarioInvalido.class, tarea1);

        Executable tarea2 = () -> Escenario.getInstance();
        assertThrows(TamañoDelEscenarioInvalido.class, tarea2);
    }
    
}
