package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.Chocables.ControlPolicial;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.*;

public class ControlPolicialTest {




    @Test
    public void laPenalizacionSeObtieneDeManeraRandomCorrectamente(){
        ControlPolicial control = new ControlPolicial();

        assertTrue(control.esPenalizado(-1.0));
        assertFalse(control.esPenalizado(2));
    }




    @Test
    public void puedoObtenerLosPuntosDePenalizacionCorrectosPorCadaVehiculo(){
        ControlPolicial controlMock = mock(ControlPolicial.class);
        Moto moto = new Moto();
        Auto auto = new Auto();
        Todoterreno todoterreno = new Todoterreno();
        Puntaje puntaje = new Puntaje();

        when(controlMock.esPenalizado(anyDouble())).thenReturn(true);
        when(controlMock.devolverEfecto(moto)).thenCallRealMethod();
        when(controlMock.devolverEfecto(auto)).thenCallRealMethod();
        when(controlMock.devolverEfecto(todoterreno)).thenCallRealMethod();

        controlMock.devolverEfecto(moto);
        assertEquals(3, puntaje.verMovimientos());
        controlMock.devolverEfecto(auto);
        assertEquals(6, puntaje.verMovimientos());
        controlMock.devolverEfecto(todoterreno);
        assertEquals(9, puntaje.verMovimientos());

        when(controlMock.esPenalizado(anyDouble())).thenReturn(false);
        controlMock.devolverEfecto(moto);
        assertEquals(9, puntaje.verMovimientos());
        controlMock.devolverEfecto(auto);
        assertEquals(9, puntaje.verMovimientos());
        controlMock.devolverEfecto(todoterreno);
        assertEquals(9, puntaje.verMovimientos());
    }



    
}