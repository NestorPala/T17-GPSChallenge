package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Movimiento.IMovimiento;

public class Posicion {
    private int x;
    private int y;

    public Posicion() {
        this.x = 0;
        this.y = 0;
    }

    public Posicion(int valorX, int valorY) {
        this.x = valorX;
        this.y = valorY;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Posicion posicion = (Posicion) obj;

        if (x != posicion.x) {
            return false;
        }
        
        return y == posicion.y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public void moverseDesdePosicionInicial(IMovimiento IMovimiento) {
        this.x = x + IMovimiento.x();
        this.y = y + IMovimiento.y();
    }
}
