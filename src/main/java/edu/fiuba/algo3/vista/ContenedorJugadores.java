package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.GPSChallenge;
import edu.fiuba.algo3.vista.Manejadores.BotonAgregarJugadorEventHandler;
import edu.fiuba.algo3.vista.Manejadores.BotonComenzarJuegoEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContenedorJugadores extends VBox {
    Stage stage;

    public ContenedorJugadores(Stage stage, GPSChallenge juego) {

        super();

        this.stage = stage;

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
        opcionesVehiculo.setPromptText("Elija el vehiculo");
        opcionesVehiculo.getItems().add("Auto");
        opcionesVehiculo.getItems().add("Moto");
        opcionesVehiculo.getItems().add("4x4");

        Button botonAgregarJugador = new Button();
        botonAgregarJugador.setText("Agregar Jugador");
        botonAgregarJugador.setFont(Font.font("Times New Roman", 36));
        botonAgregarJugador.setPrefSize(300,100);

        BotonAgregarJugadorEventHandler botonAgregarJugadorEventHandler = new BotonAgregarJugadorEventHandler(inputNombre, opcionesVehiculo, juego);
        botonAgregarJugador.setOnAction(botonAgregarJugadorEventHandler);


        Button botonComenzarJuego = new Button();
        botonComenzarJuego.setText("Comenzar juego");
        botonComenzarJuego.setFont(Font.font("Times New Roman", 36));
        botonComenzarJuego.setPrefSize(300,100);

        BotonComenzarJuegoEventHandler botonComenzarJuegoEventHandler = new BotonComenzarJuegoEventHandler(this, juego);
        botonComenzarJuego.setOnAction(botonComenzarJuegoEventHandler);

        this.getChildren().addAll(texto, inputNombre, opcionesVehiculo, botonAgregarJugador, botonComenzarJuego);
    }

    public void comenzarJuego(GPSChallenge juego){
        ContenedorEscenario contenedorEscenario = new ContenedorEscenario(this.stage, juego);
        Scene escenaEscenario = new Scene(contenedorEscenario, 1440,900);
        stage.setScene(escenaEscenario);
    }
}
