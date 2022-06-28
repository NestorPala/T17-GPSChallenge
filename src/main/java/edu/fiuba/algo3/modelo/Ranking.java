package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Jugador.Jugador;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Ranking {
    private List<Jugador> jugadores;

    public Ranking() {
        jugadores = new LinkedList<Jugador>();
    }

    public void agregar(Jugador unJugador) {
        jugadores.add(unJugador);
        jugadores.sort(Comparator.comparing(Jugador::puntaje));
    }

    public void obtenerTop10() {
        // devolver el top 10 de jugadores con su nombre y puntaje
        System.out.println(jugadores.get(0).nombre());
        System.out.println(jugadores.get(0).puntaje());
    }

    public Jugador obtenerMejorJugador() {
        return jugadores.get(0);
    }
}
