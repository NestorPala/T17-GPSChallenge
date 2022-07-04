package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.BotonAbajoEventHandler;
import edu.fiuba.algo3.controller.BotonArribaEventHandler;
import edu.fiuba.algo3.controller.BotonDerechaEventHandler;
import edu.fiuba.algo3.controller.BotonIzquierdaEventHandler;
import edu.fiuba.algo3.model.Escenario;
import edu.fiuba.algo3.model.GPSChallenge;
import edu.fiuba.algo3.model.Jugador.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class ContenedorEscenario extends BorderPane {

    Stage stage;
    VistaEscenario vistaEscenario;
    VistaJugador vistaJugador2;
    VBox contenedorCentral;
    Label puntaje;
    Label coordenadas;
    private Button botonDerecha;
    private Button botonIzquierda;
    private Button botonAbajo;
    private Button botonArriba;


    public ContenedorEscenario(Stage stage, GPSChallenge juego) {

        this.stage = stage;
        this.puntaje = new Label();
        this.setMapa(juego);
        this.setPanelEstado(juego);
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

    private void setPanelEstado(GPSChallenge juego) {

        this.puntaje = new Label();
        puntaje.setFont(Font.font("Trebuchet MS", 30));
        puntaje.setPrefSize(240,80);

        coordenadas = new Label(juego.jugadorActual().posicion().toString());
        coordenadas.setFont(Font.font("Trebuchet MS", 30));
        coordenadas.setPrefSize(240,50);

        this.updateEstado(juego.jugadorActual());

        Label labelAcciones = new Label("Acciones:");
        labelAcciones.setFont(Font.font("Trebuchet MS", 30));
        labelAcciones.setPrefSize(240,50);

        this.botonDerecha = new Button();
        botonDerecha.setText("Derecha");
        botonDerecha.setFont(Font.font("Trebuchet MS", 20));
        botonDerecha.setPrefSize(240,50);
        botonDerecha.setOnAction(new BotonDerechaEventHandler(vistaJugador2, juego, this));

        this.botonIzquierda = new Button();
        botonIzquierda.setText("Izquierda");
        botonIzquierda.setFont(Font.font("Trebuchet MS", 20));
        botonIzquierda.setPrefSize(240,50);
        botonIzquierda.setOnAction(new BotonIzquierdaEventHandler(vistaJugador2, juego, this));

        this.botonAbajo = new Button();
        botonAbajo.setText("Arriba");
        botonAbajo.setFont(Font.font("Trebuchet MS", 20));
        botonAbajo.setPrefSize(240,50);
        botonAbajo.setOnAction(new BotonAbajoEventHandler(vistaJugador2, juego, this));

        this.botonArriba = new Button();
        botonArriba.setText("Abajo");
        botonArriba.setFont(Font.font("Trebuchet MS", 20));
        botonArriba.setPrefSize(240,50);
        botonArriba.setOnAction(new BotonArribaEventHandler(vistaJugador2, juego, this));

        VBox contenedorVertical = new VBox(puntaje, coordenadas, labelAcciones, botonArriba, botonAbajo, botonIzquierda, botonDerecha);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));

        this.setLeft(contenedorVertical);
    }

    public void updateEstado(Jugador jugador) {
        this.puntaje.setText("Jugador: " + jugador.nombre() + "\n" + "Puntaje: " + new DecimalFormat("#.##").format(jugador.puntaje()));
        this.puntaje.setFont(Font.font("Trebuchet MS", 30));

        // this.setRight(this.puntaje);

        this.coordenadas.setText("Posicion: " + jugador.posicion().toString());
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
}
