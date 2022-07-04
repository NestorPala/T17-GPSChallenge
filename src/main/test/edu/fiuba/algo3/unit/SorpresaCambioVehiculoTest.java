package edu.fiuba.algo3.unit;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.model.Direccion;
import edu.fiuba.algo3.model.Escenario;
import edu.fiuba.algo3.model.Posicion;
import edu.fiuba.algo3.model.Chocables.Chocable;
import edu.fiuba.algo3.model.Chocables.Piquete;
import edu.fiuba.algo3.model.Chocables.SorpresaCambioVehiculo;
import edu.fiuba.algo3.model.Efectos.IEfecto;
import edu.fiuba.algo3.model.Jugador.Jugador;
import edu.fiuba.algo3.model.Vehiculos.Moto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SorpresaCambioVehiculoTest {
    @Test
    public void SeCambianLosVehiculosCorrectamente(){
        Escenario escenario = Escenario.getInstance();
        Moto moto = new Moto();
        Jugador jugador = new Jugador(moto, "Juan");
        Chocable sorpresaCambioVehiculo = new SorpresaCambioVehiculo();

        escenario.insertarChocable(new Piquete(), new Posicion(2,1));

        IEfecto efecto = sorpresaCambioVehiculo.devolverEfecto(moto);
        efecto.aplicarEfecto(jugador);

        jugador.mover(Direccion.derecha());

        assertEquals(1,jugador.puntaje());
    }
}