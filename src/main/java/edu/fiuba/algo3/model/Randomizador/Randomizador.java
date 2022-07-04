package edu.fiuba.algo3.model.Randomizador;

public class Randomizador implements Randomizer {
  public boolean random(double probabilidad) {
    return Math.random() >= probabilidad;
  }
}
