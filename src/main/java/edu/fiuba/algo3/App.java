package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.ContenedorEscenario;
import edu.fiuba.algo3.vista.ContenedorInicio;
import edu.fiuba.algo3.modelo.GPSChallenge;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import edu.fiuba.algo3.vista.ContenedorJugadores;
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

        GPSChallenge juego = new GPSChallenge(20, 20);


        ContenedorJugadores contenedorJugadores = new ContenedorJugadores(stage, juego);
        Scene escenaJugadores = new Scene(contenedorJugadores, 1440, 900);

        ContenedorInicio contenedorInicio = new ContenedorInicio(stage, escenaJugadores);
        Scene escenaInicial = new Scene(contenedorInicio, 1440, 900);

        stage.setScene(escenaInicial);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}