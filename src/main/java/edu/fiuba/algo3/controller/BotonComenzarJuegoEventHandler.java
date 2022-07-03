package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.GPSChallenge;
import edu.fiuba.algo3.model.Jugador.Jugador;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.view.ContenedorEscenario;
import edu.fiuba.algo3.view.ContenedorJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class BotonComenzarJuegoEventHandler implements EventHandler<ActionEvent> {

    GPSChallenge juego;
    ContenedorJugadores contenedor;

    private final static MediaPlayer sonidoClickear = new MediaPlayer(new Media(new File("src/main/java/edu/fiuba/algo3/view/sonidos/sonidoClickear.mp3").toURI().toString()));

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
