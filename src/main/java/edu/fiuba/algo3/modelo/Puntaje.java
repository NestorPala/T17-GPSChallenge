package edu.fiuba.algo3.modelo;

public class Puntaje {
    private double movimientos;

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
