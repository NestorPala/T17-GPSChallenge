package edu.fiuba.algo3.unit.general;

import edu.fiuba.algo3.model.General.Direccion;
import edu.fiuba.algo3.model.General.Logger;
import edu.fiuba.algo3.model.Jugador.Jugador;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import org.junit.jupiter.api.Test;

public class LoggerTest {
  @Test
  public void test01_sePuedeLoggearCorrectamente() {
    Logger.getInstance().activar();

    Jugador jugador = new Jugador(new Moto(), "Jorge");
    jugador.mover(Direccion.derecha());

    Logger.getInstance().desactivar();

    jugador.mover(Direccion.abajo());
  }
}
