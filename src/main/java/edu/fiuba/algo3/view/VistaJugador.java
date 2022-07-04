package edu.fiuba.algo3.view;


import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

import edu.fiuba.algo3.model.GPSChallenge;
import edu.fiuba.algo3.model.Vehiculos.Vehiculo;
import javafx.util.Duration;

public class VistaJugador {

    private double escalaJugador = 1;
    private final VistaEscenario vistaEscenario;
    ImageView imagenJugador;
    private final GPSChallenge juego;
    private int ultimaPosicionX;
    private Vehiculo vehiculoJugador;


    public VistaJugador(VistaEscenario escenario, GPSChallenge juego) {

        this.vistaEscenario = escenario;
        this.juego = juego;
        this.ultimaPosicionX = juego.jugadorActual().posicion().x();
        this.vehiculoJugador = juego.jugadorActual().vehiculo();

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
        this.orientarVehiculo(actualX);

        if(juego.jugadorActual().vehiculo() != vehiculoJugador){
            vistaEscenario.limpiarEscenario(imagenJugador);
            Imagenes imagenes = new Imagenes();
            imagenJugador = imagenes.devolverImagenesVehiculos(juego.jugadorActual().vehiculo());
            imagenJugador.setFitHeight(32);
            imagenJugador.setFitWidth(32);
            this.orientarVehiculo(actualX);
        }
        this.ultimaPosicionX = juego.jugadorActual().posicion().x();
        vistaEscenario.addViewOnMap(this.imagenJugador, actualX, actualY);

        /*TranslateTransition animacion = new TranslateTransition();
        animacion.setNode(imagenJugador);
        animacion.setDuration(Duration.seconds(1));
        animacion.setFromX(juego.jugadorActual().posicionAnterior().x());
        animacion.setFromY(juego.jugadorActual().posicionAnterior().y());
        //animacion.setToX(actualX);
        //animacion.setToY(actualY);
        animacion.setToX(200);
        animacion.setToY(200);
        animacion.play();*/
    }

    public void orientarVehiculo(int actualX){
        if (ultimaPosicionX > actualX) {
            this.imagenJugador.setScaleX( -
                    Math.abs(imagenJugador.getScaleX()));
        }

        else if (ultimaPosicionX < actualX) {
            this.imagenJugador.setScaleX(
                    Math.abs(imagenJugador.getScaleX()));
        }
    }
}

