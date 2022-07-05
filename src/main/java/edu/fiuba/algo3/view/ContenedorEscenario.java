package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.*;
import edu.fiuba.algo3.model.General.Escenario;
import edu.fiuba.algo3.model.General.GPSChallenge;
import edu.fiuba.algo3.model.Jugador.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.text.DecimalFormat;

public class ContenedorEscenario extends BorderPane {

    Stage stage;
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

    private final static MediaPlayer musica = new MediaPlayer(new Media(new File("src/main/java/edu/fiuba/algo3/view/sonidos/musica.mp3").toURI().toString()));


    public ContenedorEscenario(Stage stage, GPSChallenge juego) {

        this.stage = stage;
        this.puntaje = new Label();
        this.setMapa(juego);
        this.setPanelEstado(juego);
        this.setMenu(stage);
        this.setStyle("-fx-background-color: #333333;");
        musica.setVolume(0.3);
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
        puntaje.setPrefSize(300,80);
        puntaje.setStyle(
                "-fx-background-radius: 5;" +
                "-fx-text-fill: #010B40;" +
                "-fx-background-color: #88AABF;"+
                "-fx-alignment: center");

        this.coordenadas = new Label(juego.jugadorActual().posicion().toString());
        coordenadas.setFont(Font.font("SansSerif", 30));
        coordenadas.setPrefSize(300,50);
        coordenadas.setStyle(
                "-fx-padding: 10;" +
                "-fx-background-radius: 5;" +
                "-fx-text-fill: #010B40;" +
                "-fx-background-color: #88AABF;"+
                "-fx-alignment: center");

        this.updateEstado(juego.jugadorActual());

        this.botonDerecha = new Button();
        ImageView flechaDerecha = new ImageView();
        flechaDerecha.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/view/fotos/flechaDerecha.png").toURI().toString()));
        botonDerecha.setGraphic(flechaDerecha);
        botonDerecha.setStyle("-fx-background-color: transparent;");
        botonDerecha.setFocusTraversable(false);
        botonDerecha.setOnAction(new BotonDerechaEventHandler(vistaJugador2, juego, this));

        this.botonIzquierda = new Button();
        ImageView flechaIzquierda = new ImageView();
        flechaIzquierda.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/view/fotos/flechaIzquierda.png").toURI().toString()));
        botonIzquierda.setGraphic(flechaIzquierda);
        botonIzquierda.setStyle("-fx-background-color: transparent;");
        botonIzquierda.setFocusTraversable(false);
        botonIzquierda.setOnAction(new BotonIzquierdaEventHandler(vistaJugador2, juego, this));

        this.botonAbajo = new Button();
        ImageView flechaArriba = new ImageView();
        flechaArriba.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/view/fotos/flechaArriba.png").toURI().toString()));
        botonAbajo.setGraphic(flechaArriba);
        botonAbajo.setStyle("-fx-background-color: transparent;");
        botonAbajo.setFocusTraversable(false);
        botonAbajo.setOnAction(new BotonAbajoEventHandler(vistaJugador2, juego, this));

        this.botonArriba = new Button();
        ImageView flechaAbajo = new ImageView();
        flechaAbajo.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/view/fotos/flechaAbajo.png").toURI().toString()));
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

        VBox contenedorTodosLosBotones = new VBox(botonRanking, contenedorBotonesVertical);
        contenedorTodosLosBotones.setAlignment(Pos.CENTER);
        contenedorTodosLosBotones.setSpacing(450);

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

        if(obstaculo == "vacio"){
            return;
        }else if(obstaculo == "meta"){
            Toast.makeText(stage,"Felicidades!! Llegaste a la meta",1000,500,500);
        }else {
            Toast.makeText(stage,"Te chocaste con " + obstaculo,1000,500,500);
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
        fotoRanking.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/view/fotos/ranking.png").toURI().toString()));
        botonRanking.setGraphic(fotoRanking);
        botonRanking.setStyle("-fx-background-color: transparent;");
        botonRanking.setFocusTraversable(false);
        botonRanking.setOnAction(new BotonRankingEventHandler(stage, juego));
        return botonRanking;
    }
}
