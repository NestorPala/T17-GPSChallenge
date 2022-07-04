package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.BotonAtrasEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContenedorOpciones extends VBox {

    Stage stage;
    public ContenedorOpciones(Stage stage, Scene escenaAnterior) {

        super();

        this.setAlignment(Pos.CENTER);
        this.setSpacing(50);
        this.setPadding(new Insets(50));

        Label textoOpciones = new Label();
        textoOpciones.setText("OPCIONES");
        textoOpciones.setFont(Font.font("Trebuchet MS", 100));

        Label textoDificultad = new Label();
        textoDificultad.setText("Elegir dificultad");
        textoDificultad.setFont(Font.font("Trebuchet MS", 36));

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

        botonFacil.selectedProperty().addListener((observable, wasSelected, isSelected) -> {
            if (isSelected) {
                System.out.println("FACIL");
            }
        });

        botonNormal.selectedProperty().addListener((observable, wasSelected, isSelected) -> {
            if (isSelected) {
                System.out.println("NORMAL");
            }
        });

        botonDificil.selectedProperty().addListener((observable, wasSelected, isSelected) -> {
            if (isSelected) {
                System.out.println("DIFICIL");
            }
        });

        Button botonAtras = new Button();
        botonAtras.setText("Atrás");
        botonAtras.setFont(Font.font("Trebuchet MS", 50));
        botonAtras.setPrefSize(300,100);
        botonAtras.setOnAction(new BotonAtrasEventHandler(stage, escenaAnterior));

        this.getChildren().addAll(textoOpciones, textoDificultad, botonFacil, botonNormal, botonDificil, botonAtras);
    }

}
