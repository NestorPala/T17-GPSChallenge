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
    Stage stage;
    private final static MediaPlayer sonidoSeleccionar = new MediaPlayer(new Media(new File("src/main/java/edu/fiuba/algo3/view/sonidos/sonidoSeleccionar.mp3").toURI().toString()));

    public ContenedorDificultad(Stage stage) {
        super();

        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(50);
        this.setPadding(new Insets(50));

        Label textoDificultad = new Label();
        textoDificultad.setText("ELEGIR DIFICULTAD");
        textoDificultad.setFont(Font.font("Trebuchet MS", 78));

        ToggleGroup grupoBotones = new ToggleGroup();

        RadioButton botonFacil = new RadioButton("Fácil");
        botonFacil.setFont(Font.font("Trebuchet MS", 24));
        botonFacil.setToggleGroup(grupoBotones);

        RadioButton botonNormal = new RadioButton("Normal");
        botonNormal.setFont(Font.font("Trebuchet MS", 24));
        botonNormal.setToggleGroup(grupoBotones);
        botonNormal.setSelected(true);

        RadioButton botonDificil = new RadioButton("Difícil");
        botonDificil.setFont(Font.font("Trebuchet MS", 24));
        botonDificil.setToggleGroup(grupoBotones);

        Button botonSeleccionar = new Button();
        botonSeleccionar.setText("Seleccionar");
        botonSeleccionar.setFont(Font.font("Trebuchet MS", 36));
        botonSeleccionar.setPrefSize(300,100);

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
