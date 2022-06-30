package edu.fiuba.algo3.interfazGrafica;

import edu.fiuba.algo3.interfazGrafica.Manejadores.BotonAbajoEventHandler;
import edu.fiuba.algo3.interfazGrafica.Manejadores.BotonArribaEventHandler;
import edu.fiuba.algo3.interfazGrafica.Manejadores.BotonDerechaEventHandler;
import edu.fiuba.algo3.interfazGrafica.Manejadores.BotonIzquierdaEventHandler;
import edu.fiuba.algo3.modelo.GPSChallenge;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContenedorEscenario extends BorderPane {

    Stage stage;
    VistaEscenario vistaEscenario;
    VistaJugador2 vistaJugador2;
    VBox contenedorCentral;

    Label texto;

    public ContenedorEscenario(Stage stage, GPSChallenge juego){

        this.stage = stage;
        this.texto = new Label();
        this.setCentro(juego);
        this.setBotonera(juego);
        this.setPuntaje(juego.jugadorActual());

    }

    private void setCentro(GPSChallenge juego) {
        vistaEscenario = new VistaEscenario(20, 20);
        vistaJugador2 = new VistaJugador2(vistaEscenario, juego);

        contenedorCentral = new VBox(vistaEscenario);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(20);
        contenedorCentral.setPadding(new Insets(25));

        this.setCenter(contenedorCentral);
    }

    private void setBotonera(GPSChallenge juego) {

        Button botonDerecha = new Button();
        botonDerecha.setText("Derecha");
        botonDerecha.setFont(Font.font("Times New Roman", 20));
        botonDerecha.setPrefSize(120,50);
        BotonDerechaEventHandler botonDerechaEventHandler = new BotonDerechaEventHandler(vistaJugador2, juego, this);
        botonDerecha.setOnAction(botonDerechaEventHandler);

        Button botonIzquierda = new Button();
        botonIzquierda.setText("Izquierda");
        botonIzquierda.setFont(Font.font("Times New Roman", 20));
        botonIzquierda.setPrefSize(120,50);
        BotonIzquierdaEventHandler botonIzquierdaEventHandler = new BotonIzquierdaEventHandler(vistaJugador2, juego, this);
        botonIzquierda.setOnAction(botonIzquierdaEventHandler);

        Button botonAbajo = new Button();
        botonAbajo.setText("Arriba");
        botonAbajo.setFont(Font.font("Times New Roman", 20));
        botonAbajo.setPrefSize(120,50);
        BotonAbajoEventHandler botonAbajoEventHandler = new BotonAbajoEventHandler(vistaJugador2, juego, this);
        botonAbajo.setOnAction(botonAbajoEventHandler);

        Button botonArriba = new Button();
        botonArriba.setText("Abajo");
        botonArriba.setFont(Font.font("Times New Roman", 20));
        botonArriba.setPrefSize(120,50);
        BotonArribaEventHandler botonArribaEventHandler = new BotonArribaEventHandler(vistaJugador2, juego, this);
        botonArriba.setOnAction(botonArribaEventHandler);

        VBox contenedorVertical = new VBox(botonArriba, botonAbajo, botonDerecha, botonIzquierda);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));

        this.setLeft(contenedorVertical);
    }

    public void setPuntaje(Jugador jugador){
        this.texto.setText("Puntaje: " + jugador.puntaje());
        this.texto.setFont(Font.font("Times New Roman", 50));


        this.setRight(this.texto);
    }

}
