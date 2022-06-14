package edu.fiuba.algo3.modelo;

//import edu.fiuba.algo3.modelo.Movimientos.IMovimiento;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Posicion posicion = (Posicion) o;

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
