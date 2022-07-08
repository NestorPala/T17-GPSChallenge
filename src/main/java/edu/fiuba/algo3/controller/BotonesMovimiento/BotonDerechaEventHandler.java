package edu.fiuba.algo3.controller.BotonesMovimiento;

import edu.fiuba.algo3.model.General.GPSChallenge;
import edu.fiuba.algo3.model.Movimiento.Direccion;
import edu.fiuba.algo3.view.scenes.Contenedores.ContenedorEscenario;
import edu.fiuba.algo3.view.scenes.Vistas.VistaJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class BotonDerechaEventHandler implements EventHandler<ActionEvent> {

    private final VistaJugador vistaJugador;
    private final GPSChallenge juego;

    private final ContenedorEscenario contenedor;

    private final static MediaPlayer sonidoAuto = new MediaPlayer(new Media(new File("src/main/java/edu/fiuba/algo3/view/resources/sounds/sonidoAuto.mp3").toURI().toString()));

    public BotonDerechaEventHandler(VistaJugador vistaJugador, GPSChallenge juego, ContenedorEscenario contenedor) {
        this.vistaJugador = vistaJugador;
        this.juego = juego;
        this.contenedor = contenedor;
        sonidoAuto.setVolume(0.2);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (juego.jugadorActual().puedeSeguirJugando()) {
            juego.mover(Direccion.derecha());
            sonidoAuto.play();
            sonidoAuto.seek(sonidoAuto.getStartTime());
        }
        vistaJugador.actualizar();
        contenedor.updateEstado(juego.jugadorActual());
        contenedor.notificarChoque(juego.jugadorActual());
    }
}
