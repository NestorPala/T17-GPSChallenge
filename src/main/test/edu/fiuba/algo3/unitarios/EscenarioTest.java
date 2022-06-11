package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.Chocables.Pozo;
import edu.fiuba.algo3.modelo.Escenario;
import edu.fiuba.algo3.modelo.PosicionDelEscenarioInvalida;
import edu.fiuba.algo3.modelo.Posicion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class EscenarioTest {




    @Test
    public void noSePuedeCrearUnEscenarioConUnTamanioInvalido() {
        Executable tarea1 = () -> new Escenario(-5, 5);
        assertThrows(PosicionDelEscenarioInvalida.class, tarea1);

        Executable tarea2 = () -> new Escenario(5, -5);
        assertThrows(PosicionDelEscenarioInvalida.class, tarea2);
    }




    // Para chequear si el jugador se sale del escenario
    // Esto va en la clase jugador
    @Test
    public void noSePuedeRealizarUnMovimientoHaciaUnaPosicionInvalida() 
    throws PosicionDelEscenarioInvalida 
    {
        Escenario escenario = new Escenario(10, 10);

        assertFalse(escenario.estaDentroDelEscenario(new Posicion(11, 11)));
        assertFalse(escenario.estaDentroDelEscenario(new Posicion(5,15)));
        assertFalse(escenario.estaDentroDelEscenario(new Posicion(15,5)));
        assertFalse(escenario.estaDentroDelEscenario(new Posicion(-3,5)));
        assertFalse(escenario.estaDentroDelEscenario(new Posicion(6,-5)));
        assertTrue(escenario.estaDentroDelEscenario(new Posicion(2,8)));
        assertTrue(escenario.estaDentroDelEscenario(new Posicion(9,1)));
    }




    @Test
    public void noSePuedeColocarUnChocableFueraDeLosLimitesDelEscenario() 
    throws PosicionDelEscenarioInvalida 
    {
        Escenario escenario = new Escenario(10, 10);
        Pozo pozo = new Pozo();

        escenario.insertarChocable(pozo, new Posicion(11, 11));
        assertNull(escenario.obtenerChocable(new Posicion(11, 11)));
    }
    


    // "Obtener chocable en posicion" es un metodo 
    // que se deberia usar de manera interna unicamente

    // @Test
    // public void noSePuedeObtenerUnChocableDeUnLugarFueraDeLosLimitesDelEscenario() 
    // throws PosicionDelEscenarioInvalida 
    // {
    //     Escenario escenario = new Escenario(10, 10);

    //     assertNull(escenario.obtenerChocable(new Posicion(11, 11)));
    // }



}
