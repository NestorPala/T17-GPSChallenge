package edu.fiuba.algo3.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

import edu.fiuba.algo3.model.GPSChallenge;
import edu.fiuba.algo3.model.Jugador.Jugador;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import edu.fiuba.algo3.model.Vehiculos.Todoterreno;
import edu.fiuba.algo3.model.Vehiculos.Vehiculo;

public class BotonAgregarJugadorEventHandler implements EventHandler<ActionEvent> {

    private final GPSChallenge juego;
    private final TextField inputNombre;
    private final ComboBox<String> opcionesVehiculos;
    private final static MediaPlayer sonidoSeleccionar = new MediaPlayer(new Media(new File("src/main/java/edu/fiuba/algo3/view/sonidoSeleccionar.mp3").toURI().toString()));


    public BotonAgregarJugadorEventHandler(TextField inputNombre, ComboBox<String> opcionesVehiculos, GPSChallenge juego) {
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
        String nombre = inputNombre.getText();
        if (nombre == "") { return "Pepe"; }
        return inputNombre.getText();
    }

    private Vehiculo seleccionarVehiculo(ComboBox<String> opcionesVehiculos) {
        String tipoVehiculo = opcionesVehiculos.getValue();
        if (tipoVehiculo == "Auto") {
            return new Auto();
        } else if (tipoVehiculo == "Moto") {
            return new Moto();
        } else if (tipoVehiculo == "4x4") {
            return new Todoterreno();
        } else {
            return new Auto();
        }
    }
}
