package edu.fiuba.algo3.model.Chocables;

import edu.fiuba.algo3.model.Efectos.IEfecto;
import edu.fiuba.algo3.model.Efectos.Penalizacion;
import edu.fiuba.algo3.model.Randomizador.Randomizer;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import edu.fiuba.algo3.model.Vehiculos.Todoterreno;

public class ControlPolicial implements Chocable {
  private final double PROBABILIDAD_MOTO = 0.2;
  private final double PROBABILIDAD_AUTO = 0.5;
  private final double PROBABILIDAD_TODOTERRENO = 0.7;
  private final int PENALIZACION = 3;

  private final Randomizer randomizador;

  public ControlPolicial(Randomizer randomizer) {
    this.randomizador = randomizer;
  }

  @Override
  public IEfecto devolverEfecto(Moto moto) {
    if (this.randomizador.random(PROBABILIDAD_MOTO)) return new Penalizacion(PENALIZACION);
    return new Penalizacion(0);
  }

  @Override
  public IEfecto devolverEfecto(Auto auto) {
    if (this.randomizador.random(PROBABILIDAD_AUTO)) return new Penalizacion(PENALIZACION);
    return new Penalizacion(0);
  }

  @Override
  public IEfecto devolverEfecto(Todoterreno todoterreno) {
    if (this.randomizador.random(PROBABILIDAD_TODOTERRENO)) return new Penalizacion(PENALIZACION);
    return new Penalizacion(0);
  }

  @Override
  public String toString() {
    return "control policial";
  }
}
