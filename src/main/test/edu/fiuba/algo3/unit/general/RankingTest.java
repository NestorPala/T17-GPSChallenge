package edu.fiuba.algo3.unit.general;

import edu.fiuba.algo3.model.Chocables.Meta;
import edu.fiuba.algo3.model.General.Escenario;
import edu.fiuba.algo3.model.Jugador.Jugador;
import edu.fiuba.algo3.model.Movimiento.Direccion;
import edu.fiuba.algo3.model.Movimiento.Posicion;
import edu.fiuba.algo3.model.Puntaje.Ranking;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RankingTest {

  @Test
  public void test01_agrego10JugadoresYElMejorJugadorTieneElMenorPuntaje() {
    Ranking ranking = new Ranking();
    Escenario escenario = Escenario.getInstance().reset();
    escenario.insertarChocable(new Meta(), new Posicion(1, 2));

    assertNull(ranking.obtenerJugadorDelTop(0));
    assertNull(ranking.obtenerMejorJugador());

    Jugador j1 = new Jugador(new Moto(), "Mati");
    Jugador j2 = new Jugador(new Auto(), "Lorenzo");

    j1.mover(Direccion.derecha());
    j2.mover(Direccion.arriba());
    j2.mover(Direccion.derecha());
    j2.mover(Direccion.abajo());

    ranking.agregar(j1);
    ranking.agregar(j2);

    assertEquals(ranking.obtenerMejorJugador(), j1);
    assertEquals(ranking.obtenerJugadorDelTop(1), j2);
  }
}
