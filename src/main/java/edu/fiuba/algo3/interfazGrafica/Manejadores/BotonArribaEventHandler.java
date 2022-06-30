package edu.fiuba.algo3.interfazGrafica.Manejadores;

import edu.fiuba.algo3.interfazGrafica.ContenedorEscenario;
import edu.fiuba.algo3.interfazGrafica.VistaJugador2;
import edu.fiuba.algo3.modelo.Direccion;
import edu.fiuba.algo3.modelo.GPSChallenge;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonArribaEventHandler implements EventHandler<ActionEvent> {

    private final VistaJugador2 vistaJugador;
    private final GPSChallenge juego;

    private final ContenedorEscenario contenedor;

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
    }
}
