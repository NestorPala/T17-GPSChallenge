package edu.fiuba.algo3.model;


public class Posicion {
    private int x;
    private int y;

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object otraPosicion) {
        if (this == otraPosicion) return true;
        if (otraPosicion == null || getClass() != otraPosicion.getClass()) return false;

        Posicion posicion = (Posicion) otraPosicion;

        if (x != posicion.x) return false;
        return y == posicion.y;
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }

    public void sumarX(int x) {
        this.x += x;
    }

    public void sumarY(int y) {
        this.y += y;
    }
}
