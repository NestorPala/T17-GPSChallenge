package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.Chocables.Chocable;
import edu.fiuba.algo3.modelo.Chocables.Piquete;
import edu.fiuba.algo3.modelo.Chocables.SorpresaCambioVehiculo;
import edu.fiuba.algo3.modelo.Direccion;
import edu.fiuba.algo3.modelo.Efectos.IEfecto;
import edu.fiuba.algo3.modelo.Escenario;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import org.junit.jupiter.api.Test;

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