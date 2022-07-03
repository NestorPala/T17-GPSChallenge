package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.BotonAgregarJugadorEventHandler;
import edu.fiuba.algo3.controller.BotonComenzarJuegoEventHandler;
import edu.fiuba.algo3.model.GPSChallenge;
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
        texto.setFont(Font.font("Trebuchet MS", 70));

        TextField inputNombre = new TextField();
        inputNombre.setMaxWidth(300);
        inputNombre.setMinHeight(75);
        inputNombre.setPromptText("Ingrese su nombre");
        inputNombre.setFocusTraversable(false);
        inputNombre.setFont(Font.font("Trebuchet MS", 24));

        ComboBox<String> opcionesVehiculo = new ComboBox<>();
        opcionesVehiculo.setMinWidth(300);
        opcionesVehiculo.setMinHeight(75);
        opcionesVehiculo.setPromptText("Elija el vehiculo");
        opcionesVehiculo.setStyle("-fx-font: 24px \"Trebuchet MS\";");
        opcionesVehiculo.getItems().add("Auto");
        opcionesVehiculo.getItems().add("Moto");
        opcionesVehiculo.getItems().add("4x4");

        Button botonAgregarJugador = new Button();
        botonAgregarJugador.setText("Agregar Jugador");
        botonAgregarJugador.setFont(Font.font("Trebuchet MS", 36));
        botonAgregarJugador.setPrefSize(300,100);
        botonAgregarJugador.setOnAction(new BotonAgregarJugadorEventHandler(inputNombre, opcionesVehiculo, juego));


        Button botonComenzarJuego = new Button();
        botonComenzarJuego.setText("Comenzar juego");
        botonComenzarJuego.setFont(Font.font("Trebuchet MS", 36));
        botonComenzarJuego.setPrefSize(300,100);
        botonComenzarJuego.setOnAction(new BotonComenzarJuegoEventHandler(this, juego));

        this.getChildren().addAll(texto, inputNombre, opcionesVehiculo, botonAgregarJugador, botonComenzarJuego);
    }

    public void comenzarJuego(GPSChallenge juego){
        ContenedorEscenario contenedorEscenario = new ContenedorEscenario(this.stage, juego);
        Scene escenaEscenario = new Scene(contenedorEscenario, 960,540);
        stage.setScene(escenaEscenario);
        contenedorEscenario.setBotones();
    }
}
