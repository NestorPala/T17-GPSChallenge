package edu.fiuba.algo3.view.scenes.Contenedores;

import edu.fiuba.algo3.controller.BotonesMenus.BotonRankingEventHandler;
import edu.fiuba.algo3.controller.BotonesMovimiento.BotonAbajoEventHandler;
import edu.fiuba.algo3.controller.BotonesMovimiento.BotonArribaEventHandler;
import edu.fiuba.algo3.controller.BotonesMovimiento.BotonDerechaEventHandler;
import edu.fiuba.algo3.controller.BotonesMovimiento.BotonIzquierdaEventHandler;
import edu.fiuba.algo3.model.General.Escenario;
import edu.fiuba.algo3.model.General.GPSChallenge;
import edu.fiuba.algo3.model.Jugador.Jugador;
import edu.fiuba.algo3.view.scenes.BarraDeMenu;
import edu.fiuba.algo3.view.scenes.Toast;
import edu.fiuba.algo3.view.scenes.Vistas.VistaEscenario;
import edu.fiuba.algo3.view.scenes.Vistas.VistaJugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Optional;

public class ContenedorEscenario extends BorderPane {

    final Stage stage;
    VistaEscenario vistaEscenario;
    VistaJugador vistaJugador2;
    VBox contenedorCentral;
    BarraDeMenu menuBar;
    Label puntaje;
    Label coordenadas;
    private Button botonDerecha;
    private Button botonIzquierda;
    private Button botonAbajo;
    private Button botonArriba;

    private final static MediaPlayer musica = new MediaPlayer(new Media(new File("src/main/java/edu/fiuba/algo3/view/resources/sounds/musica.mp3").toURI().toString()));


    public ContenedorEscenario(Stage stage, GPSChallenge juego) {

        this.stage = stage;
        this.puntaje = new Label();
        this.setMapa(juego);
        this.setPanelEstado(juego);
        this.setMenu(stage);
        this.setStyle("-fx-background-color: #333333;");
        musica.setVolume(0.3);
        musica.setCycleCount(MediaPlayer.INDEFINITE);
        musica.play();
        musica.seek(musica.getStartTime());
    }

    private void setMapa(GPSChallenge juego) {
        int anchoEscenario = Escenario.getInstance().ancho();
        int altoEscenario = Escenario.getInstance().alto();

        vistaEscenario = new VistaEscenario(anchoEscenario, altoEscenario);
        vistaJugador2 = new VistaJugador(vistaEscenario, juego);

        contenedorCentral = new VBox(vistaEscenario);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(20);
        contenedorCentral.setPadding(new Insets(25));

        this.setCenter(contenedorCentral);
    }

    private void setMenu(Stage stage){
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    private void setPanelEstado(GPSChallenge juego) {

        this.puntaje = new Label();
        puntaje.setFont(Font.font("SansSerif", 30));
        puntaje.setPrefSize(300,100);
        puntaje.setStyle(
                "-fx-background-radius: 5;" +
                "-fx-text-fill: #010B40;" +
                "-fx-background-color: #88AABF;"+
                "-fx-alignment: center");

        this.coordenadas = new Label(juego.jugadorActual().posicion().toString());
        coordenadas.setFont(Font.font("SansSerif", 30));
        coordenadas.setPrefSize(300,60);
        coordenadas.setStyle(
                "-fx-padding: 10;" +
                "-fx-background-radius: 5;" +
                "-fx-text-fill: #010B40;" +
                "-fx-background-color: #88AABF;"+
                "-fx-alignment: center");

        this.updateEstado(juego.jugadorActual());

        this.botonDerecha = new Button();
        ImageView flechaDerecha = new ImageView();
        flechaDerecha.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/view/resources/images/flechaDerecha.png").toURI().toString()));
        botonDerecha.setGraphic(flechaDerecha);
        botonDerecha.setStyle("-fx-background-color: transparent;");
        botonDerecha.setFocusTraversable(false);
        botonDerecha.setOnAction(new BotonDerechaEventHandler(vistaJugador2, juego, this));

        this.botonIzquierda = new Button();
        ImageView flechaIzquierda = new ImageView();
        flechaIzquierda.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/view/resources/images/flechaIzquierda.png").toURI().toString()));
        botonIzquierda.setGraphic(flechaIzquierda);
        botonIzquierda.setStyle("-fx-background-color: transparent;");
        botonIzquierda.setFocusTraversable(false);
        botonIzquierda.setOnAction(new BotonIzquierdaEventHandler(vistaJugador2, juego, this));

        this.botonAbajo = new Button();
        ImageView flechaArriba = new ImageView();
        flechaArriba.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/view/resources/images/flechaArriba.png").toURI().toString()));
        botonAbajo.setGraphic(flechaArriba);
        botonAbajo.setStyle("-fx-background-color: transparent;");
        botonAbajo.setFocusTraversable(false);
        botonAbajo.setOnAction(new BotonAbajoEventHandler(vistaJugador2, juego, this));

        this.botonArriba = new Button();
        ImageView flechaAbajo = new ImageView();
        flechaAbajo.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/view/resources/images/flechaAbajo.png").toURI().toString()));
        botonArriba.setGraphic(flechaAbajo);
        botonArriba.setStyle("-fx-background-color: transparent;");
        botonArriba.setFocusTraversable(false);
        botonArriba.setOnAction(new BotonArribaEventHandler(vistaJugador2, juego, this));

        Button botonRanking = setRanking(juego);

        VBox contenedorInfo = new VBox(puntaje, coordenadas);
        contenedorInfo.setSpacing(20);
        contenedorInfo.setPadding(new Insets(15));

        HBox contenedorBotonesHorizontal = new HBox(botonIzquierda, botonArriba, botonDerecha);
        contenedorBotonesHorizontal.setSpacing(2);
        contenedorBotonesHorizontal.setPadding(new Insets(2));

        VBox contenedorBotonesVertical = new VBox(botonAbajo, contenedorBotonesHorizontal);
        contenedorBotonesVertical.setAlignment(Pos.CENTER);
        contenedorBotonesVertical.setSpacing(2);
        contenedorBotonesVertical.setPadding(new Insets(2));

        Label labelRanking = new Label();
        labelRanking.setFont(Font.font("SansSerif", 30));
        labelRanking.setPrefSize(300,80);
        labelRanking.setStyle(
                "-fx-background-radius: 5;" +
                        "-fx-text-fill: #010B40;" +
                        "-fx-background-color: #88AABF;"+
                        "-fx-alignment: center");
        labelRanking.setText("Ranking:");

        Label labelAcciones = new Label();
        labelAcciones.setFont(Font.font("SansSerif", 30));
        labelAcciones.setPrefSize(300,80);
        labelAcciones.setStyle(
                "-fx-background-radius: 5;" +
                        "-fx-text-fill: #010B40;" +
                        "-fx-background-color: #88AABF;"+
                        "-fx-alignment: center");
        labelAcciones.setText("Acciones:");

        VBox contenedorTodosLosBotones = new VBox(labelRanking, botonRanking, labelAcciones, contenedorBotonesVertical);
        contenedorTodosLosBotones.setAlignment(Pos.CENTER);
        contenedorTodosLosBotones.setSpacing(75);

        this.setLeft(contenedorInfo);
        this.setRight(contenedorTodosLosBotones);
    }

    public void updateEstado(Jugador jugador) {
        this.puntaje.setText("Jugador: " + jugador.nombre() + "\n" + "Puntaje: " + new DecimalFormat("#.##").format(jugador.puntaje()));
        this.puntaje.setFont(Font.font("SansSerif", 30));

        this.coordenadas.setText("Posicion: " + jugador.posicion().toString());
    }

    public void notificarChoque(Jugador jugador){
        String obstaculo = Escenario.getInstance().obtenerChocable(jugador.posicion()).toString();

        if(obstaculo.equals("vacio")){
            return;
        }

        if(obstaculo.equals("meta")){
            Toast.makeText(stage,"Felicidades!! Llegaste a la meta",500,500,500);
            popUpFinDelJuego();
        }else if(obstaculo.equals("sorpresa de cambio de vehiculo")){
            Toast.makeText(stage,"Te chocaste con " + obstaculo + "\nTu nuevo vehiculo es: " + jugador.vehiculo().toString(),500,500,500);
        }else{
            Toast.makeText(stage,"Te chocaste con " + obstaculo,250,500,500);
        }
    }

    public void setBotones() {
        this.stage.getScene().addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            if (e.getCode() == KeyCode.RIGHT) {
                botonDerecha.fire();
            } else if (e.getCode() == KeyCode.LEFT) {
                botonIzquierda.fire();
            } else if (e.getCode() == KeyCode.UP) {
                botonAbajo.fire();
            } else if (e.getCode() == KeyCode.DOWN) {
                botonArriba.fire();
            }
        });
    }

    public Button setRanking(GPSChallenge juego) {
        Button botonRanking = new Button();
        ImageView fotoRanking = new ImageView();
        fotoRanking.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/view/resources/images/ranking.png").toURI().toString()));
        botonRanking.setGraphic(fotoRanking);
        botonRanking.setStyle("-fx-background-color: transparent;");
        botonRanking.setFocusTraversable(false);
        botonRanking.setOnAction(new BotonRankingEventHandler(stage, juego));
        return botonRanking;
    }

    public void popUpFinDelJuego() {
        Alert popup = new Alert(Alert.AlertType.INFORMATION);
        popup.setTitle("Juego finalizado");
        popup.setHeaderText("La partida terminó");
        popup.setContentText("Todos los jugadores terminaron su turno y no quedan jugadores por jugar.\n" +
                "Puede volver al menú e iniciar una nueva partida, aceptar y ver el ranking o salir.");

        ButtonType botonMenu = new ButtonType("Menú principal");
        ButtonType botonSalir = new ButtonType("Salir");
        ButtonType botonAceptar = new ButtonType("Aceptar", ButtonBar.ButtonData.OK_DONE);
        popup.getButtonTypes().setAll(botonMenu, botonSalir, botonAceptar);

        Optional<ButtonType> botonPresionado = popup.showAndWait();
        if (botonPresionado.get() == botonMenu) {
                Escenario.getInstance().reset();
                reiniciarJuego(stage);
        } else if (botonPresionado.get() == botonSalir) {
                System.exit(0);
        }
    }

    private void reiniciarJuego(Stage stage) {
        int resAncho = (int) Screen.getPrimary().getBounds().getWidth();
        int resAlto = (int) Screen.getPrimary().getBounds().getHeight();

        ContenedorDificultad contenedorDificultad = new ContenedorDificultad(stage);
        Scene escenaDificultad = new Scene(contenedorDificultad, resAncho, resAlto);

        ContenedorInicio contenedorInicio = new ContenedorInicio(stage, escenaDificultad);
        Scene escenaInicial = new Scene(contenedorInicio, resAncho, resAlto);

        stage.setScene(escenaInicial);
    }
}
