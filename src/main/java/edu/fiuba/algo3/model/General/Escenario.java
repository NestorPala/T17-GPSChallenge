package edu.fiuba.algo3.model.General;

import edu.fiuba.algo3.model.Chocables.*;
import edu.fiuba.algo3.model.Exceptions.TamanioDelEscenarioInvalido;
import edu.fiuba.algo3.model.Movimiento.Posicion;
import edu.fiuba.algo3.model.Randomizador.Randomizador;

import java.util.Random;

public class Escenario {
  private final int alto;
  private final int ancho;
  private final Chocable[][] chocables;

  private static Escenario instance;

  private Escenario(int limiteAlto, int limiteAncho) {

    this.alto = limiteAlto;
    this.ancho = limiteAncho;
    this.chocables = new Chocable[this.ancho][this.alto];

    for (int i = 0; i < this.ancho; i++) {
      for (int j = 0; j < this.alto; j++) {
        chocables[i][j] = new Vacio();
      }
    }
  }

  public void generarObstaculos() {
    Random random = new Random();
    for (int i = 0; i < this.ancho; i++) {
      for (int j = 0; j < this.alto; j++) {
        int randomInt = random.nextInt(12);
        switch (randomInt) {
          case 0:
            chocables[i][j] = new ControlPolicial(new Randomizador());
            break;
          case 1:
            chocables[i][j] = new Piquete();
            break;
          case 2:
            chocables[i][j] = new Pozo();
            break;
          case 3:
            chocables[i][j] = new SorpresaCambioVehiculo();
            break;
          case 4:
            chocables[i][j] = new SorpresaFavorable();
            break;
          case 5:
            chocables[i][j] = new SorpresaDesfavorable();
            break;
        }
      }
    }

    int metaAlto = random.nextInt(this.alto - this.alto / 2) + this.alto / 2;
    int metaAncho = random.nextInt(this.ancho - this.ancho / 2) + this.ancho / 2;

    chocables[metaAlto][metaAncho] = new Meta();
  }

  public static Escenario getInstance() {
    if (instance == null) {
      instance = Escenario.getInstance(10, 10);
    }
    return instance;
  }

  public static Escenario getInstance(int alto, int ancho) throws TamanioDelEscenarioInvalido {
    if (alto < 0 || ancho < 0) {
      throw new TamanioDelEscenarioInvalido();
    }

    if (instance == null) {
      instance = new Escenario(alto, ancho);
    }

    return instance;
  }

  public boolean contienePosicion(Posicion posicion) {
    int posX = posicion.x();
    int posY = posicion.y();

    if (posX < 0 || posX > ancho - 1) {
      return false;
    }
    return posY >= 0 && posY <= alto - 1;
  }

  public void insertarChocable(Chocable chocable, Posicion posicion) {
    if (contienePosicion(posicion)) {
      chocables[posicion.x()][posicion.y()] = chocable;
    }
  }

  public Chocable obtenerChocable(Posicion posicion) {
    if (contienePosicion(posicion)) {
      return chocables[posicion.x()][posicion.y()];
    }
    return null;
  }

  public Escenario reset() {
    instance = new Escenario(this.alto, this.ancho);
    return instance;
  }

  public int alto() {
    return this.alto;
  }

  public int ancho() {
    return this.ancho;
  }
}
