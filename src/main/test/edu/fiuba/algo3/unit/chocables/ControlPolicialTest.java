package edu.fiuba.algo3.unit.chocables;

import edu.fiuba.algo3.model.Chocables.Chocable;
import edu.fiuba.algo3.model.Chocables.ControlPolicial;
import edu.fiuba.algo3.model.Efectos.IEfecto;
import edu.fiuba.algo3.model.Jugador.Jugador;
import edu.fiuba.algo3.model.Randomizador.Randomizer;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import edu.fiuba.algo3.model.Vehiculos.Todoterreno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControlPolicialTest {

  @Test
  public void test01_puedoObtenerLosPuntosDePenalizacionCorrectosSiSeAplicaLaProbabilidad() {
    Randomizer randomMock = mock(Randomizer.class);
    when(randomMock.random(anyDouble())).thenReturn(true);

    Chocable controlPolicial = new ControlPolicial(randomMock);
    Jugador jugador1 = new Jugador(new Auto(), "Juan");

    IEfecto efecto = controlPolicial.devolverEfecto(new Auto());
    efecto.aplicarEfecto(jugador1);
    assertEquals(jugador1.puntaje(), 3);

    IEfecto efecto2 = controlPolicial.devolverEfecto(new Moto());
    efecto2.aplicarEfecto(jugador1);
    assertEquals(jugador1.puntaje(), 6);

    IEfecto efecto3 = controlPolicial.devolverEfecto(new Todoterreno());
    efecto3.aplicarEfecto(jugador1);
    assertEquals(jugador1.puntaje(), 9);

    assertEquals(controlPolicial.toString(), "control policial");
  }

  @Test
  public void test02_puedoObtenerLosPuntosDePenalizacionCorrectosSiNoSeAplicaLaProbabilidad() {
    Randomizer randomMock = mock(Randomizer.class);
    when(randomMock.random(anyDouble())).thenReturn(false);

    Chocable controlPolicial = new ControlPolicial(randomMock);
    Jugador jugador1 = new Jugador(new Auto(), "Juan");

    IEfecto efecto = controlPolicial.devolverEfecto(new Auto());
    efecto.aplicarEfecto(jugador1);
    assertEquals(jugador1.puntaje(), 0);

    IEfecto efecto2 = controlPolicial.devolverEfecto(new Moto());
    efecto2.aplicarEfecto(jugador1);
    assertEquals(jugador1.puntaje(), 0);

    IEfecto efecto3 = controlPolicial.devolverEfecto(new Todoterreno());
    efecto3.aplicarEfecto(jugador1);
    assertEquals(jugador1.puntaje(), 0);
  }
}
