package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.vista.Manejadores.BotonJugarEventHandler;
import edu.fiuba.algo3.vista.Manejadores.BotonOpcionesEventHandler;
import edu.fiuba.algo3.vista.Manejadores.BotonSalirEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;

public class ContenedorInicio extends VBox {

    Stage stage;

    public ContenedorInicio(Stage stage, Scene proximaEscena){

        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        Button botonJugar = new Button();
        botonJugar.setText("Jugar");
        botonJugar.setFont(Font.font("Times New Roman", 50));
        botonJugar.setPrefSize(300,100);

        Button botonOpciones = new Button();
        botonOpciones.setText("Opciones");
        botonOpciones.setFont(Font.font("Times New Roman", 50));
        botonOpciones.setPrefSize(300,100);

        Button botonSalir = new Button();
        botonSalir.setText("Salir");
        botonSalir.setFont(Font.font("Times New Roman", 50));
        botonSalir.setPrefSize(300,100);

        Label texto = new Label();
        texto.setText("GPS CHALLENGE");
        texto.setFont(Font.font("Times New Roman", 100));

        ContenedorOpciones contenedorOpciones = new ContenedorOpciones(stage, stage.getScene());
        Scene escenaOpciones = new Scene(contenedorOpciones, 1440,900);

        BotonJugarEventHandler botonJugarEventHandler = new BotonJugarEventHandler(stage, proximaEscena);
        botonJugar.setOnAction(botonJugarEventHandler);

        BotonOpcionesEventHandler botonOpcionesEventHandler = new BotonOpcionesEventHandler(stage, escenaOpciones);
        botonOpciones.setOnAction(botonOpcionesEventHandler);

        BotonSalirEventHandler botonSalirEventHandler = new BotonSalirEventHandler();
        botonSalir.setOnAction(botonSalirEventHandler);

        stage.getIcons().add(new Image(new File("src/main/java/edu/fiuba/algo3/interfazGrafica/gps.png").toURI().toString()));

        this.getChildren().addAll(texto, botonJugar, botonOpciones, botonSalir);
    }

}
