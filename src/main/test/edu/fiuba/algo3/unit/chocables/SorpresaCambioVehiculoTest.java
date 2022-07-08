package edu.fiuba.algo3.unit.chocables;

import edu.fiuba.algo3.model.Chocables.Chocable;
import edu.fiuba.algo3.model.Chocables.Piquete;
import edu.fiuba.algo3.model.Chocables.SorpresaCambioVehiculo;
import edu.fiuba.algo3.model.Efectos.IEfecto;
import edu.fiuba.algo3.model.General.Escenario;
import edu.fiuba.algo3.model.Jugador.Jugador;
import edu.fiuba.algo3.model.Movimiento.Direccion;
import edu.fiuba.algo3.model.Movimiento.Posicion;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SorpresaCambioVehiculoTest {
  @Test
  public void test01_SeCambianLosVehiculosCorrectamente() {
    Escenario escenario = Escenario.getInstance();
    Moto moto = new Moto();
    Jugador jugador = new Jugador(moto, "Juan");
    Chocable sorpresaCambioVehiculo = new SorpresaCambioVehiculo();

    escenario.insertarChocable(new Piquete(), new Posicion(2, 1));

    IEfecto efecto = sorpresaCambioVehiculo.devolverEfecto(moto);
    efecto.aplicarEfecto(jugador);

    jugador.mover(Direccion.derecha());

    assertEquals(1, jugador.puntaje());

    assertEquals(sorpresaCambioVehiculo.toString(), "sorpresa de cambio de vehiculo");
  }
}
