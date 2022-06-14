package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.Chocables.Chocable;
import edu.fiuba.algo3.modelo.Chocables.ControlPolicial;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.*;

public class ControlPolicialTest {
    @Test
    public void puedoObtenerLosPuntosDePenalizacionCorrectosPorCadaVehiculo(){
        ControlPolicial controlMock = mock(ControlPolicial.class);
        Moto moto = new Moto();
        Auto auto = new Auto();
        Todoterreno todoterreno = new Todoterreno();
        Puntaje puntaje = new Puntaje();

        when(controlMock.esPenalizado(anyDouble())).thenReturn(true);
        when(controlMock.aplicarPenalizacion(moto,puntaje)).thenCallRealMethod();
        when(controlMock.aplicarPenalizacion(auto,puntaje)).thenCallRealMethod();
        when(controlMock.aplicarPenalizacion(todoterreno,puntaje)).thenCallRealMethod();

        controlMock.aplicarPenalizacion(moto, puntaje);
        assertEquals(3, puntaje.verMovimientos());
        controlMock.aplicarPenalizacion(auto,puntaje);
        assertEquals(6, puntaje.verMovimientos());
        controlMock.aplicarPenalizacion(todoterreno, puntaje);
        assertEquals(9, puntaje.verMovimientos());

        when(controlMock.esPenalizado(anyDouble())).thenReturn(false);
        controlMock.aplicarPenalizacion(moto, puntaje);
        assertEquals(9, puntaje.verMovimientos());
        controlMock.aplicarPenalizacion(auto,puntaje);
        assertEquals(9, puntaje.verMovimientos());
        controlMock.aplicarPenalizacion(todoterreno, puntaje);
        assertEquals(9, puntaje.verMovimientos());
    }
}