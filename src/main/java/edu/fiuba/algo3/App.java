package edu.fiuba.algo3;

import edu.fiuba.algo3.interfazGrafica.ContenedorEscenario;
import edu.fiuba.algo3.interfazGrafica.ContenedorInicio;
import edu.fiuba.algo3.modelo.Escenario;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {


        stage.setTitle("GPS CHALLENGE");

        Jugador jugador = crearModelo();

        ContenedorEscenario contenedorEscenario = new ContenedorEscenario(stage, jugador);
        Scene escenaEscenario = new Scene(contenedorEscenario, 1080,720);

        ContenedorInicio contenedorInicio = new ContenedorInicio(stage, escenaEscenario);
        Scene escenaInicial = new Scene(contenedorInicio, 1080, 720);

        stage.setScene(escenaInicial);
        stage.show();
    }

    private Jugador crearModelo(){
        Escenario escenario = Escenario.getInstance(20, 20);
        Vehiculo vehiculo = new Moto();
        Jugador jugador = new Jugador(vehiculo, "Pepe");
        return jugador;
    }

    public static void main(String[] args) {
        launch();
    }

}