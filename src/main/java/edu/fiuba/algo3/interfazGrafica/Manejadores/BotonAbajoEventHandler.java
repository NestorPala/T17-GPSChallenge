package edu.fiuba.algo3.interfazGrafica.Manejadores;

import edu.fiuba.algo3.interfazGrafica.ContenedorEscenario;
import edu.fiuba.algo3.interfazGrafica.VistaJugador2;
import edu.fiuba.algo3.modelo.Direccion;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAbajoEventHandler implements EventHandler<ActionEvent> {

    private final VistaJugador2 vistaJugador;
    private final Jugador jugador;

    private final ContenedorEscenario contenedor;

    public BotonAbajoEventHandler(VistaJugador2 vistaJugador, Jugador jugador, ContenedorEscenario contenedor){
        this.vistaJugador = vistaJugador;
        this.jugador = jugador;
        this.contenedor = contenedor;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("Jugador se mueve a abajo");
        jugador.mover(Direccion.abajo());
        vistaJugador.actualizar();
        contenedor.setPuntaje(jugador);
    }
}
