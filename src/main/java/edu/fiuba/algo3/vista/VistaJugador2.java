package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.modelo.GPSChallenge;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class VistaJugador2 {

    private double escalaJugador = 1;
    private final VistaEscenario vistaEscenario;
    ImageView imagenJugador;
    private final GPSChallenge juego;
    private int ultimaPosicionX;


    public VistaJugador2(VistaEscenario escenario, GPSChallenge juego) {

        this.vistaEscenario = escenario;
        this.juego = juego;
        this.ultimaPosicionX = juego.jugadorActual().posicion().x();

        Imagenes imagenes = new Imagenes();
        imagenJugador = imagenes.devolverImagenesVehiculos(juego.jugadorActual().vehiculo());
        imagenJugador.setScaleX(escalaJugador);
        imagenJugador.setScaleY(escalaJugador);
        imagenJugador.setFitHeight(32);
        imagenJugador.setFitWidth(32);

        escenario.addViewOnMap(imagenJugador, juego.jugadorActual().posicion().x(), juego.jugadorActual().posicion().y());
    }

    public void actualizar() {

        int actualX = juego.jugadorActual().posicion().x();
        int actualY = juego.jugadorActual().posicion().y();
        if (ultimaPosicionX > actualX) {
            this.imagenJugador.setScaleX( -
                    Math.abs(imagenJugador.getScaleX()));
        }

        else if (ultimaPosicionX < actualX) {
            this.imagenJugador.setScaleX(
                    Math.abs(imagenJugador.getScaleX()));
        }

        this.ultimaPosicionX = juego.jugadorActual().posicion().x();
        vistaEscenario.addViewOnMap(this.imagenJugador, actualX, actualY);
    }

}

