/*

Esto es una idea.

package edu.fiuba.algo3.model.Jugador;

import edu.fiuba.algo3.model.Chocables.Chocable;
import edu.fiuba.algo3.model.Efectos.IEfecto;
import edu.fiuba.algo3.view.Toast;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

public class JugadorObserver implements Observer {
    private int posX;
    private int posY;
    private String vehiculo;
    private double puntaje;
    private String ultimoChocable;
    private String ultimoEfecto;


    public JugadorObserver(){
        super();
    }

    @Override
    public void update(Observable o, Object arg){
        Jugador jugador = (Jugador)o;

        this.posX = jugador.posicion().x();
        this.posY = jugador.posicion().y();
        this.vehiculo = jugador.vehiculo().toString();
        this.puntaje = jugador.puntaje();

        if(arg instanceof Chocable){
            this.ultimoChocable = arg.toString();
        }else if(arg instanceof IEfecto){
            this.ultimoEfecto = arg.toString();
        }
    }

    public void notificar(Stage stage){
        Toast.makeText(stage, "Te chocaste con " + ultimoChocable + " Penalizacion: " + ultimoEfecto, 1000, 500, 500);
    }
}
*/
