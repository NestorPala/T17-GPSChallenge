package edu.fiuba.algo3.view.scenes.Vistas;


import javafx.scene.image.ImageView;

import edu.fiuba.algo3.model.General.GPSChallenge;
import edu.fiuba.algo3.model.Vehiculos.Vehiculo;
import edu.fiuba.algo3.view.resources.Imagenes;

public class VistaJugador {

    private final double escalaJugador = 1;
    private final VistaEscenario vistaEscenario;
    ImageView imagenJugador;
    private final GPSChallenge juego;
    private int ultimaPosicionX;
    private final Vehiculo vehiculoJugador;


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

