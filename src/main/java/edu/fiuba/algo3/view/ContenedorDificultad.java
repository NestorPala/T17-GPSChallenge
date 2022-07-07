package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.BotonSeleccionarEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;

public class ContenedorDificultad extends VBox {
    final Stage stage;
    private final static MediaPlayer sonidoSeleccionar = new MediaPlayer(new Media(new File("src/main/java/edu/fiuba/algo3/view/sonidos/sonidoSeleccionar.mp3").toURI().toString()));

    public ContenedorDificultad(Stage stage) {
        super();

        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(50);
        this.setPadding(new Insets(50));
        this.setStyle("-fx-background-color: #333333;");

        Label textoDificultad = new Label();
        textoDificultad.setText("ELEGIR DIFICULTAD");
        textoDificultad.setFont(Font.font("Trebuchet MS", 78));
        textoDificultad.setStyle(
                "-fx-padding: 10;" +
                "-fx-background-radius: 5;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #010B40;" +
                "-fx-background-color: #88AABF;"+
                "-fx-alignment: center");

        ToggleGroup grupoBotones = new ToggleGroup();

        RadioButton botonFacil = new RadioButton("Fácil");
        botonFacil.setFont(Font.font("SansSerif", 28));
        botonFacil.setStyle("-fx-text-fill: #F2F2F2");
        botonFacil.setToggleGroup(grupoBotones);

        RadioButton botonNormal = new RadioButton("Normal");
        botonNormal.setFont(Font.font("SansSerif", 28));
        botonNormal.setStyle("-fx-text-fill: #F2F2F2");
        botonNormal.setToggleGroup(grupoBotones);
        botonNormal.setSelected(true);

        RadioButton botonDificil = new RadioButton("Difícil");
        botonDificil.setFont(Font.font("SansSerif", 28));
        botonDificil.setStyle("-fx-text-fill: #F2F2F2");
        botonDificil.setToggleGroup(grupoBotones);

        Button botonSeleccionar = new Button();
        botonSeleccionar.setText("Seleccionar");
        botonSeleccionar.setFont(Font.font("SansSerif", 36));
        botonSeleccionar.setPrefSize(300,100);
        botonSeleccionar.setStyle("-fx-background-color: #BDD9F2;" + "-fx-text-fill: #010B40;" + "-fx-background-radius: 10;");

        botonSeleccionar.setOnAction(new BotonSeleccionarEventHandler(this.stage, 13));

        botonFacil.selectedProperty().addListener((observable, wasSelected, isSelected) -> {
            if (isSelected) {
                sonidoSeleccionar.play();
                sonidoSeleccionar.seek(sonidoSeleccionar.getStartTime());
                botonSeleccionar.setOnAction(new BotonSeleccionarEventHandler(this.stage, 10));
            }
        });

        botonNormal.selectedProperty().addListener((observable, wasSelected, isSelected) -> {
            if (isSelected) {
                sonidoSeleccionar.play();
                sonidoSeleccionar.seek(sonidoSeleccionar.getStartTime());
                botonSeleccionar.setOnAction(new BotonSeleccionarEventHandler(this.stage, 13));
            }
        });

        botonDificil.selectedProperty().addListener((observable, wasSelected, isSelected) -> {
            if (isSelected) {
                sonidoSeleccionar.play();
                sonidoSeleccionar.seek(sonidoSeleccionar.getStartTime());
                botonSeleccionar.setOnAction(new BotonSeleccionarEventHandler(this.stage, 16));
            }
        });

        this.getChildren().addAll(textoDificultad, botonFacil, botonNormal, botonDificil, botonSeleccionar);
    }
}
