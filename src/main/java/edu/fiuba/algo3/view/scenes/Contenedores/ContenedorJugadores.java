package edu.fiuba.algo3.view.scenes.Contenedores;

import edu.fiuba.algo3.controller.BotonesMenus.BotonAgregarJugadorEventHandler;
import edu.fiuba.algo3.controller.BotonesMenus.BotonComenzarJuegoEventHandler;
import edu.fiuba.algo3.model.General.GPSChallenge;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import edu.fiuba.algo3.model.Vehiculos.Todoterreno;
import edu.fiuba.algo3.view.resources.Imagenes;
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
    final Stage stage;

    public ContenedorJugadores(Stage stage, GPSChallenge juego) {

        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(50);
        this.setPadding(new Insets(50));
        this.setStyle("-fx-background-color: #333333;");

        Label texto = new Label();
        texto.setText("ELEGIR JUGADORES");
        texto.setFont(Font.loadFont("file:src/main/java/edu/fiuba/algo3/view/resources/fonts/main.ttf", 70));
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
        inputNombre.setFont(Font.loadFont("file:src/main/java/edu/fiuba/algo3/view/resources/fonts/main.ttf", 28));

        Imagenes imagenes = new Imagenes();
        ImageView imagenAuto = imagenes.devolverImagenesVehiculos(new Auto());
        ImageView imagenMoto = imagenes.devolverImagenesVehiculos(new Moto());
        ImageView imagenTodoterreno = imagenes.devolverImagenesVehiculos(new Todoterreno());

        Label labelAuto = new Label("Auto");
        labelAuto.setFont(Font.loadFont("file:src/main/java/edu/fiuba/algo3/view/resources/fonts/main.ttf", 28));
        Label labelMoto = new Label("Moto");
        labelMoto.setFont(Font.loadFont("file:src/main/java/edu/fiuba/algo3/view/resources/fonts/main.ttf", 28));
        Label labelTodoterreno = new Label("Todoterreno");
        labelTodoterreno.setFont(Font.loadFont("file:src/main/java/edu/fiuba/algo3/view/resources/fonts/main.ttf", 28));

        ContenedorVehiculo contenedorAuto = new ContenedorVehiculo(labelAuto, imagenAuto);
        ContenedorVehiculo contenedorMoto = new ContenedorVehiculo(labelMoto, imagenMoto);
        ContenedorVehiculo contenedorTodoterreno = new ContenedorVehiculo(labelTodoterreno, imagenTodoterreno);

        ComboBox<ContenedorVehiculo> opcionesVehiculo = crearSeleccionadorVehiculos(contenedorAuto, contenedorMoto, contenedorTodoterreno);

        Button botonAgregarJugador = new Button();
        botonAgregarJugador.setText("Agregar Jugador");
        botonAgregarJugador.setFont(Font.loadFont("file:src/main/java/edu/fiuba/algo3/view/resources/fonts/main.ttf", 36));
        botonAgregarJugador.setPrefSize(350,100);
        botonAgregarJugador.setStyle("-fx-background-color: #F0F2F2;" + "-fx-text-fill: #010B40;" + "-fx-background-radius: 10;");
        botonAgregarJugador.setOnAction(new BotonAgregarJugadorEventHandler(inputNombre, opcionesVehiculo, juego));


        Button botonComenzarJuego = new Button();
        botonComenzarJuego.setText("Comenzar Juego");
        botonComenzarJuego.setFont(Font.loadFont("file:src/main/java/edu/fiuba/algo3/view/resources/fonts/main.ttf", 40));
        botonComenzarJuego.setPrefSize(400,120);
        botonComenzarJuego.setStyle("-fx-background-color: #BDD9F2;" + "-fx-text-fill: #010B40;" + "-fx-background-radius: 10;");
        botonComenzarJuego.setOnAction(new BotonComenzarJuegoEventHandler(this, juego));

        this.getChildren().addAll(texto, inputNombre, opcionesVehiculo, botonAgregarJugador, botonComenzarJuego);
    }

    public ComboBox<ContenedorVehiculo> crearSeleccionadorVehiculos(ContenedorVehiculo cAuto, ContenedorVehiculo cMoto, ContenedorVehiculo cTodoterreno) {
        ComboBox<ContenedorVehiculo> opcionesVehiculo = new ComboBox<>();
        opcionesVehiculo.setMinWidth(350);
        opcionesVehiculo.setMinHeight(75);
        opcionesVehiculo.setPromptText("Elija el vehículo");
        opcionesVehiculo.setStyle("-fx-font: 28px \"SansSerif\";");
        opcionesVehiculo.getItems().addAll(cAuto, cMoto, cTodoterreno);

        opcionesVehiculo.setCellFactory(param -> new ListCell<>() {
            final ImageView imagenASeleccionar = new ImageView();

            @Override
            protected void updateItem(ContenedorVehiculo contenedor, boolean vacio) {
                super.updateItem(contenedor, vacio);
                if (contenedor == null || vacio) {
                    setText(null);
                    setGraphic(null);
                    imagenASeleccionar.setImage(null);
                } else {
                    setText(contenedor.obtenerTipo().getText());
                    imagenASeleccionar.setImage(contenedor.obtenerImagen().getImage());
                    setGraphic(imagenASeleccionar);
                }
            }
        });

        class CeldaIconoTexto extends ListCell<ContenedorVehiculo> {
            final ImageView imagenSeleccionada = new ImageView();

            @Override
            protected void updateItem(ContenedorVehiculo contenedor, boolean vacio) {
                super.updateItem(contenedor, vacio);
                if (contenedor != null) {
                    setText(contenedor.obtenerTipo().getText());
                    imagenSeleccionada.setImage(contenedor.obtenerImagen().getImage());
                    setGraphic(imagenSeleccionada);
                }
            }
        }

        opcionesVehiculo.setButtonCell(new CeldaIconoTexto());

        return opcionesVehiculo;
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
