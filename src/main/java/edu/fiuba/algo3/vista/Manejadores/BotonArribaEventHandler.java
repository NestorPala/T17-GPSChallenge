package edu.fiuba.algo3.vista.Manejadores;

import edu.fiuba.algo3.vista.ContenedorEscenario;
import edu.fiuba.algo3.vista.VistaJugador2;
import edu.fiuba.algo3.modelo.Direccion;
import edu.fiuba.algo3.modelo.GPSChallenge;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class BotonArribaEventHandler implements EventHandler<ActionEvent> {

    private final VistaJugador2 vistaJugador;
    private final GPSChallenge juego;

    private final ContenedorEscenario contenedor;

    private final static MediaPlayer sonidoAuto = new MediaPlayer(new Media(new File("src/main/java/edu/fiuba/algo3/interfazGrafica/sonidoAuto.mp3").toURI().toString()));

    public BotonArribaEventHandler(VistaJugador2 vistaJugador, GPSChallenge juego, ContenedorEscenario contenedor){
        this.vistaJugador = vistaJugador;
        this.juego = juego;
        this.contenedor = contenedor;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        juego.mover(Direccion.arriba());
        vistaJugador.actualizar();
        contenedor.setPuntaje(juego.jugadorActual());
        sonidoAuto.play();
        sonidoAuto.stop();
    }
}
