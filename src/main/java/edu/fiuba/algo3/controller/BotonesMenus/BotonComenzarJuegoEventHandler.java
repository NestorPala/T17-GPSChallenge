package edu.fiuba.algo3.controller.BotonesMenus;

import edu.fiuba.algo3.model.General.GPSChallenge;
import edu.fiuba.algo3.model.Jugador.Jugador;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.view.ContenedorJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class BotonComenzarJuegoEventHandler implements EventHandler<ActionEvent> {

    final GPSChallenge juego;
    final ContenedorJugadores contenedor;

    private final static MediaPlayer sonidoClickear = new MediaPlayer(new Media(new File("src/main/java/edu/fiuba/algo3/view/resources/sounds/sonidoClickear.mp3").toURI().toString()));

    public BotonComenzarJuegoEventHandler(ContenedorJugadores contenedorJugadores, GPSChallenge juego) {
        this.juego = juego;
        this.contenedor = contenedorJugadores;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        sonidoClickear.play();
        sonidoClickear.seek(sonidoClickear.getStartTime());
        if (!juego.hayJugadoresPorJugar() && juego.jugadorActual() == null) {
            juego.agregarJugador(new Jugador(new Auto(), "Jugador"));
        }
        this.contenedor.comenzarJuego(juego);
    }
}
