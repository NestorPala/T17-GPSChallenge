package edu.fiuba.algo3.unit.chocables;

import edu.fiuba.algo3.model.Chocables.Chocable;
import edu.fiuba.algo3.model.Chocables.SorpresaDesfavorable;
import edu.fiuba.algo3.model.Efectos.IEfecto;
import edu.fiuba.algo3.model.Jugador.Jugador;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import edu.fiuba.algo3.model.Vehiculos.Todoterreno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SorpresaDesfavorableTest {

  @Test
  public void test01_puedoObtenerLosPuntosDePenalizacionCorrectosPorCadaVehiculo() {
    Chocable sorpresaDesfavorable = new SorpresaDesfavorable();
    Jugador jugador1 = new Jugador(new Auto(), "Juan");
    jugador1.recibirPenalizacion(10);

    IEfecto efecto = sorpresaDesfavorable.devolverEfecto(new Auto());
    efecto.aplicarEfecto(jugador1);
    assertEquals(jugador1.puntaje(), 12.5);

    IEfecto efecto2 = sorpresaDesfavorable.devolverEfecto(new Moto());
    efecto2.aplicarEfecto(jugador1);
    assertEquals(jugador1.puntaje(), 15.625);

    IEfecto efecto3 = sorpresaDesfavorable.devolverEfecto(new Todoterreno());
    efecto3.aplicarEfecto(jugador1);
    assertEquals(jugador1.puntaje(), 19.53125);
  }
}
