package edu.fiuba.algo3.view;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;

import edu.fiuba.algo3.controller.BotonJugarEventHandler;
import edu.fiuba.algo3.controller.BotonOpcionesEventHandler;
import edu.fiuba.algo3.controller.BotonSalirEventHandler;

public class ContenedorInicio extends VBox {

    Stage stage;

    public ContenedorInicio(Stage stage, Scene proximaEscena) {

        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        BackgroundSize backgroundSize = new BackgroundSize(900,700,true,true,true,false);

        this.setBackground(
            new Background(
            new BackgroundImage(
            new Image(
            new File(
                "src/main/java/edu/fiuba/algo3/view/fotos/splash.jpg")
                .toURI()
                .toString()
            ), 
            BackgroundRepeat.REPEAT, 
            BackgroundRepeat.REPEAT, 
            BackgroundPosition.CENTER, 
            backgroundSize
        )));

        Button botonJugar = new Button();
        botonJugar.setText("Jugar");
        botonJugar.setFont(Font.font("Trebuchet MS", 50));
        botonJugar.setPrefSize(300,100);

        Button botonOpciones = new Button();
        botonOpciones.setText("Opciones");
        botonOpciones.setFont(Font.font("Trebuchet MS", 50));
        botonOpciones.setPrefSize(300,100);

        Button botonSalir = new Button();
        botonSalir.setText("Salir");
        botonSalir.setFont(Font.font("Trebuchet MS", 50));
        botonSalir.setPrefSize(300,100);

        Label texto = new Label();
        texto.setText("GPS CHALLENGE");
        texto.setFont(Font.font("Trebuchet MS", 100));
        texto.setStyle("-fx-text-fill:WHITE;");

        botonJugar.setOnAction(new BotonJugarEventHandler(stage, proximaEscena));
        botonOpciones.setOnAction(new BotonOpcionesEventHandler(stage));
        botonSalir.setOnAction(new BotonSalirEventHandler());

        stage.getIcons().add(new Image(new File("src/main/java/edu/fiuba/algo3/view/fotos/gps.png").toURI().toString()));

        this.getChildren().addAll(texto, botonJugar, botonOpciones, botonSalir);
    }

}
