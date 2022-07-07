package edu.fiuba.algo3.unit.chocables;

import edu.fiuba.algo3.model.Chocables.Piquete;
import edu.fiuba.algo3.model.Chocables.Sorpresata;
import edu.fiuba.algo3.model.Efectos.IEfecto;
import edu.fiuba.algo3.model.General.Direccion;
import edu.fiuba.algo3.model.General.Escenario;
import edu.fiuba.algo3.model.General.Posicion;
import edu.fiuba.algo3.model.Jugador.Jugador;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import edu.fiuba.algo3.model.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SorpresataTest {
    @Test
    public void test01_PuedoObtenerLosPuntosDePenalizacionCorrectos(){
        Sorpresata sorpresata = new Sorpresata();
        Escenario escenario = Escenario.getInstance().reset();
        Moto moto = new Moto();
        Jugador jugador1 = new Jugador(moto, "Pablo");

        jugador1.mover(Direccion.derecha());
        jugador1.mover(Direccion.derecha());
        jugador1.mover(Direccion.derecha());

        IEfecto efecto1 = sorpresata.devolverEfecto(moto);
        efecto1.aplicarEfecto(jugador1);

        assertEquals(jugador1.puntaje(), 5);

        jugador1.mover(Direccion.derecha());

        IEfecto efecto2 = sorpresata.devolverEfecto(moto);
        efecto2.aplicarEfecto(jugador1);

        assertEquals(jugador1.puntaje(),6);

        // Compruebo si se cambio el vehiculo
        assertEquals(jugador1.posicion(), new Posicion(5,1));
        escenario.insertarChocable(new Piquete(), new Posicion(6,1));
        jugador1.mover(Direccion.derecha());

        assertEquals(jugador1.puntaje(),7);
        assertEquals(jugador1.posicion(), new Posicion(5,1));
    }
}
