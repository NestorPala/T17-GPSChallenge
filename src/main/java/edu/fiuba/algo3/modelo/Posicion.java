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

    private boolean equals_(Posicion otraPosicion) {
        if (this == otraPosicion) {
            return true;
        }

        if (otraPosicion == null || getClass() != otraPosicion.getClass()) {
            return false;
        }

        if (this.x != otraPosicion.x || this.y != otraPosicion.y) {
            return false;
        }
        
        return true;
    }

    @Override
    public boolean equals(Object otraPosicion) {
        return this.equals_((Posicion) otraPosicion);
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
