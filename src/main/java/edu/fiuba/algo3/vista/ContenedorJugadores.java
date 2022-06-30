package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.GPSChallenge;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import edu.fiuba.algo3.vista.Manejadores.BotonJugarEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContenedorJugadores extends VBox {
    Scene escenaSiguiente;
    Stage stage;

    public ContenedorJugadores(Stage stage, Scene escenaSiguiente, GPSChallenge juego) {

        super();

        this.stage = stage;
        this.escenaSiguiente = escenaSiguiente;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        Label texto = new Label();
        texto.setText("ELEGIR JUGADORES");
        texto.setFont(Font.font("Times New Roman", 70));

        TextField inputNombre = new TextField();
        inputNombre.setMaxWidth(300);
        inputNombre.setMinHeight(75);
        inputNombre.setPromptText("Ingrese su nombre");
        inputNombre.setFont(Font.font("Times New Roman", 24));

        ComboBox<String> opcionesVehiculo = new ComboBox<>();
        opcionesVehiculo.setMinWidth(300);
        opcionesVehiculo.setMinHeight(75);
        opcionesVehiculo.setPromptText("Elija el Vehiculo");
        opcionesVehiculo.getItems().add("Auto");
        opcionesVehiculo.getItems().add("Moto");
        opcionesVehiculo.getItems().add("4x4");
        opcionesVehiculo.setOnAction(e -> seleccionarVehiculo(opcionesVehiculo));

        Button botonAgregarJugador = new Button();
        botonAgregarJugador.setText("Agregar Jugador");
        botonAgregarJugador.setFont(Font.font("Times New Roman", 36));
        botonAgregarJugador.setPrefSize(300,100);

        botonAgregarJugador.setOnAction(e -> agregarJugador(inputNombre, opcionesVehiculo, juego));

        Button botonJugar = new Button();
        botonJugar.setText("Jugar");
        botonJugar.setFont(Font.font("Times New Roman", 36));
        botonJugar.setPrefSize(300,100);

        BotonJugarEventHandler botonJugarEventHandler = new BotonJugarEventHandler(stage, escenaSiguiente);
        botonJugar.setOnAction(botonJugarEventHandler);

        this.getChildren().addAll(texto, inputNombre, opcionesVehiculo, botonAgregarJugador, botonJugar);
    }

    private void agregarJugador(TextField inputNombre, ComboBox<String> opcionesVehiculos, GPSChallenge juego) {
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
