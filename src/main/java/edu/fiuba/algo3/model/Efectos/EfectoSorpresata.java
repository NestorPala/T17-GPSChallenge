package edu.fiuba.algo3.model.Efectos;

import edu.fiuba.algo3.model.Chocables.Chocable;
import edu.fiuba.algo3.model.Chocables.Piquete;
import edu.fiuba.algo3.model.Chocables.SorpresaCambioVehiculo;
import edu.fiuba.algo3.model.General.Logger;
import edu.fiuba.algo3.model.Jugador.Jugador;
import edu.fiuba.algo3.model.Vehiculos.Vehiculo;

public class EfectoSorpresata implements IEfecto {

    @Override
    public void aplicarEfecto(Jugador jugador) {
        if ((int)jugador.puntaje() % 2 == 0) {
            Logger.getInstance().log("El jugador choca con una sorpresata que le provoca un cambio de vehiculo");
            Chocable sorpresaCambioVehiculo = new SorpresaCambioVehiculo();
            Vehiculo vehiculo = jugador.vehiculo();
            IEfecto efecto = vehiculo.chocar(sorpresaCambioVehiculo);
            efecto.aplicarEfecto(jugador);
        } else {
            Logger.getInstance().log("El jugador choca con una sorpresata que lo hace chocar con un piquete");
            Chocable piquete = new Piquete();
            Vehiculo vehiculo = jugador.vehiculo();
            IEfecto efecto = vehiculo.chocar(piquete);
            efecto.aplicarEfecto(jugador);
        }
    }
}
