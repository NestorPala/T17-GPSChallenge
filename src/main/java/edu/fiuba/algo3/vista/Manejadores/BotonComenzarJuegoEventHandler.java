package edu.fiuba.algo3.vista.Manejadores;

import edu.fiuba.algo3.modelo.GPSChallenge;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.vista.ContenedorEscenario;
import edu.fiuba.algo3.vista.ContenedorJugadores;
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

    private final static MediaPlayer sonidoClickear = new MediaPlayer(new Media(new File("src/main/java/edu/fiuba/algo3/vista/sonidoClickear.mp3").toURI().toString()));

    public BotonComenzarJuegoEventHandler(ContenedorJugadores contenedorJugadores, GPSChallenge juego) {
        this.juego = juego;
        this.contenedor = contenedorJugadores;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        sonidoClickear.play();
        sonidoClickear.seek(sonidoClickear.getStartTime());
        if (!juego.hayJugadoresPorJugar()) {
            juego.agregarJugador(new Jugador(new Auto(), "Jugador"));
        }
        this.contenedor.comenzarJuego(juego);
    }
}
