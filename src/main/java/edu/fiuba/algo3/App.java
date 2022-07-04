package edu.fiuba.algo3;

import edu.fiuba.algo3.model.GPSChallenge;
import edu.fiuba.algo3.view.ContenedorInicio;
import edu.fiuba.algo3.view.ContenedorJugadores;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {


        stage.setTitle("GPS CHALLENGE");

        GPSChallenge juego = new GPSChallenge(12, 12);


        ContenedorJugadores contenedorJugadores = new ContenedorJugadores(stage, juego);
        Scene escenaJugadores = new Scene(contenedorJugadores, 960, 540);

        ContenedorInicio contenedorInicio = new ContenedorInicio(stage, escenaJugadores);
        Scene escenaInicial = new Scene(contenedorInicio, 960, 540);

        stage.setScene(escenaInicial);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}