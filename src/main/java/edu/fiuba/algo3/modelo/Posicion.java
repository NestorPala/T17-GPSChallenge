package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Movimiento.IMovimiento;

public class Posicion {
    private int x;
    private int y;

    public Posicion() {
        this.x = 0;
        this.y = 0;
    }

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object otraPosicion) {
        if (this == otraPosicion) {
            return true;
        }

        if (otraPosicion == null || getClass() != otraPosicion.getClass()) {
            return false;
        }

        Posicion posicion = (Posicion) otraPosicion;

        if (x != posicion.x) {
            return false;
        }
        
        return y == posicion.y;
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }

    public void moverseDesdePosicionInicial(IMovimiento movimiento) {
        this.x = x + movimiento.x();
        this.y = y + movimiento.y();
    }
}
