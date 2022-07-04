package edu.fiuba.algo3;

import edu.fiuba.algo3.model.GPSChallenge;
import edu.fiuba.algo3.view.ContenedorInicio;
import edu.fiuba.algo3.view.ContenedorJugadores;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {


        stage.setTitle("GPS CHALLENGE");
        stage.setMaximized(true);

        GPSChallenge juego = new GPSChallenge(12, 12);

        int resAncho = (int) Screen.getPrimary().getBounds().getWidth();
        int resAlto = (int) Screen.getPrimary().getBounds().getHeight();

        ContenedorJugadores contenedorJugadores = new ContenedorJugadores(stage, juego);
        Scene escenaJugadores = new Scene(contenedorJugadores, resAncho, resAlto);

        ContenedorInicio contenedorInicio = new ContenedorInicio(stage, escenaJugadores);
        Scene escenaInicial = new Scene(contenedorInicio, resAncho, resAlto);

        stage.setScene(escenaInicial);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}