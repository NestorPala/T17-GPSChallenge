package edu.fiuba.algo3;

import edu.fiuba.algo3.interfazGrafica.ContenedorEscenario;
import edu.fiuba.algo3.interfazGrafica.ContenedorInicio;
import edu.fiuba.algo3.modelo.Escenario;
import edu.fiuba.algo3.modelo.GPSChallenge;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
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

        GPSChallenge juego = crearModelo();

        ContenedorEscenario contenedorEscenario = new ContenedorEscenario(stage, juego);
        Scene escenaEscenario = new Scene(contenedorEscenario, 1440,900);

        ContenedorInicio contenedorInicio = new ContenedorInicio(stage, escenaEscenario);
        Scene escenaInicial = new Scene(contenedorInicio, 1440, 900);

        stage.setScene(escenaInicial);
        stage.show();
    }

    private GPSChallenge crearModelo(){
        GPSChallenge juego = new GPSChallenge(20,20);
        Vehiculo vehiculo = new Moto();
        Jugador jugador = new Jugador(vehiculo, "Pepe");
        juego.agregarJugador(jugador);
        return juego;
    }

    public static void main(String[] args) {
        launch();
    }

}