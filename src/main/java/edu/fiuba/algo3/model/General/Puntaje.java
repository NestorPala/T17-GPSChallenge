package edu.fiuba.algo3.model.General;

public class Puntaje {
  private double movimientos;

  public Puntaje() {
    this.movimientos = 0;
  }

  public double verMovimientos() {
    return this.movimientos;
  }

  public void sumarMovimientos(int cantMovimientos) {
    this.movimientos += cantMovimientos;
  }

  public void aplicarPorcentaje(double porcentaje) {
    this.movimientos += this.movimientos * (porcentaje / 100);
  }
}
