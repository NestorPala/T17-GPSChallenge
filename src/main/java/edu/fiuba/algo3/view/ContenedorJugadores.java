package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.BotonAgregarJugadorEventHandler;
import edu.fiuba.algo3.controller.BotonComenzarJuegoEventHandler;
import edu.fiuba.algo3.model.General.GPSChallenge;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import edu.fiuba.algo3.model.Vehiculos.Todoterreno;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ContenedorJugadores extends VBox {
    Stage stage;

    public ContenedorJugadores(Stage stage, GPSChallenge juego) {

        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(50);
        this.setPadding(new Insets(50));
        this.setStyle("-fx-background-color: #333333;");

        Label texto = new Label();
        texto.setText("ELEGIR JUGADORES");
        texto.setFont(Font.font("Trebuchet MS", 70));
        texto.setStyle(
                "-fx-padding: 10;" +
                "-fx-background-radius: 5;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #010B40;" +
                "-fx-background-color: #88AABF;"+
                "-fx-alignment: center");

        TextField inputNombre = new TextField();
        inputNombre.setMaxWidth(350);
        inputNombre.setMinHeight(75);
        inputNombre.setPromptText("Ingrese su nombre");
        inputNombre.setFocusTraversable(false);
        inputNombre.setFont(Font.font("SansSerif", 28));

        ComboBox<ImageView> opcionesVehiculo = new ComboBox<>();
        opcionesVehiculo.setMinWidth(350);
        opcionesVehiculo.setMinHeight(75);
        opcionesVehiculo.setPromptText("Elija el vehiculo");
        opcionesVehiculo.setStyle("-fx-font: 28px \"SansSerif\";");
        opcionesVehiculo.getItems().add(new Imagenes().devolverImagenesVehiculos(new Auto()));
        opcionesVehiculo.getItems().add(new Imagenes().devolverImagenesVehiculos(new Moto()));
        opcionesVehiculo.getItems().add(new Imagenes().devolverImagenesVehiculos(new Todoterreno()));

        Button botonAgregarJugador = new Button();
        botonAgregarJugador.setText("Agregar Jugador");
        botonAgregarJugador.setFont(Font.font("SansSerif", 36));
        botonAgregarJugador.setPrefSize(350,100);
        botonAgregarJugador.setStyle("-fx-background-color: #BDD9F2;" + "-fx-text-fill: #010B40;" + "-fx-background-radius: 10;");
        botonAgregarJugador.setOnAction(new BotonAgregarJugadorEventHandler(inputNombre, opcionesVehiculo, juego));


        Button botonComenzarJuego = new Button();
        botonComenzarJuego.setText("Comenzar juego");
        botonComenzarJuego.setFont(Font.font("SansSerif", 36));
        botonComenzarJuego.setPrefSize(350,100);
        botonComenzarJuego.setStyle("-fx-background-color: #BDD9F2;" + "-fx-text-fill: #010B40;" + "-fx-background-radius: 10;");
        botonComenzarJuego.setOnAction(new BotonComenzarJuegoEventHandler(this, juego));

        this.getChildren().addAll(texto, inputNombre, opcionesVehiculo, botonAgregarJugador, botonComenzarJuego);
    }

    public void comenzarJuego(GPSChallenge juego){
        ContenedorEscenario contenedorEscenario = new ContenedorEscenario(this.stage, juego);
        int resAncho = (int) Screen.getPrimary().getBounds().getWidth();
        int resAlto = (int) Screen.getPrimary().getBounds().getHeight();
        Scene escenaEscenario = new Scene(contenedorEscenario, resAncho,resAlto);
        stage.setScene(escenaEscenario);
        contenedorEscenario.setBotones();
    }
}
