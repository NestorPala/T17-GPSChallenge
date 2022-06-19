package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.Chocables.Chocable;
import edu.fiuba.algo3.modelo.Chocables.SorpresaCambioVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class SorpresaCambioVehiculoTest {
    /*
    @Test
    public void SeCambianLosVehiculosCorrectamente(){
        Chocable sorpresaCambioVehiculo = new SorpresaCambioVehiculo();

        // Tengo que usar Instanceof para pasar las pruebas del codecov
        Vehiculo nuevoVehiculo = sorpresaCambioVehiculo.devolverEfecto(new Moto());
        assertTrue(nuevoVehiculo instanceof Auto);

        nuevoVehiculo = sorpresaCambioVehiculo.devolverEfecto(new Auto());
        assertTrue(nuevoVehiculo instanceof Todoterreno);

        nuevoVehiculo = sorpresaCambioVehiculo.devolverEfecto(new Todoterreno());
        assertTrue(nuevoVehiculo instanceof Moto);
    }
    */
}