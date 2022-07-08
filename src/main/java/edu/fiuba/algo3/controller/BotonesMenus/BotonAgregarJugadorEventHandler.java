package edu.fiuba.algo3.controller.BotonesMenus;

import edu.fiuba.algo3.view.ContenedorVehiculo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

import edu.fiuba.algo3.model.General.GPSChallenge;
import edu.fiuba.algo3.model.Jugador.Jugador;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import edu.fiuba.algo3.model.Vehiculos.Todoterreno;
import edu.fiuba.algo3.model.Vehiculos.Vehiculo;

public class BotonAgregarJugadorEventHandler implements EventHandler<ActionEvent> {

    private final GPSChallenge juego;
    private final TextField inputNombre;
    private final ComboBox<ContenedorVehiculo> opcionesVehiculos;
    private final static MediaPlayer sonidoSeleccionar = new MediaPlayer(new Media(new File("src/main/java/edu/fiuba/algo3/view/resources/sounds/sonidoSeleccionar.mp3").toURI().toString()));


    public BotonAgregarJugadorEventHandler(TextField inputNombre, ComboBox<ContenedorVehiculo> opcionesVehiculos, GPSChallenge juego) {
        this.inputNombre = inputNombre;
        this.opcionesVehiculos = opcionesVehiculos;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        sonidoSeleccionar.play();
        sonidoSeleccionar.seek(sonidoSeleccionar.getStartTime());
        String nombre = seleccionarNombre(inputNombre);
        Vehiculo vehiculo = seleccionarVehiculo(opcionesVehiculos);
        juego.agregarJugador(new Jugador(vehiculo, nombre));
    }

    private String seleccionarNombre(TextField inputNombre) {
        if (inputNombre.getText() == null || inputNombre.getText().trim().isEmpty()) {
            return "Pepe";
        }
        return inputNombre.getText();
    }

    private Vehiculo seleccionarVehiculo(ComboBox<ContenedorVehiculo> opcionesVehiculos) {
        if (opcionesVehiculos.getValue() == null) {
            return new Auto();
        }
        String tipoVehiculo = opcionesVehiculos.getValue().obtenerTipo().getText();
        if (tipoVehiculo == "Auto") {
            return new Auto();
        } else if (tipoVehiculo == "Moto") {
            return new Moto();
        } else {
            return new Todoterreno();
        }
    }
}
