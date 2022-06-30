package edu.fiuba.algo3.interfazGrafica.Manejadores;

import edu.fiuba.algo3.interfazGrafica.ContenedorEscenario;
import edu.fiuba.algo3.interfazGrafica.VistaJugador2;
import edu.fiuba.algo3.modelo.Direccion;
import edu.fiuba.algo3.modelo.GPSChallenge;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class BotonDerechaEventHandler implements EventHandler<ActionEvent> {

    private final VistaJugador2 vistaJugador;
    private final GPSChallenge juego;

    private final ContenedorEscenario contenedor;

    private final static MediaPlayer sonidoAuto = new MediaPlayer(new Media(new File("src/main/java/edu/fiuba/algo3/interfazGrafica/sonidoAuto.mp3").toURI().toString()));

    public BotonDerechaEventHandler(VistaJugador2 vistaJugador, GPSChallenge juego, ContenedorEscenario contenedor){
        this.vistaJugador = vistaJugador;
        this.juego = juego;
        this.contenedor = contenedor;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        juego.mover(Direccion.derecha());
        vistaJugador.actualizar();
        contenedor.setPuntaje(juego.jugadorActual());
        sonidoAuto.play();
        sonidoAuto.stop();
    }
}
