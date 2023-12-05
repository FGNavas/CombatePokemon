package com.example.combatepokemon.Modelo;

import com.example.combatepokemon.Interfaces.CombateListener;

public class Combate {
    private Jugador jugador1;
    private Jugador jugador2;
    private boolean esJugador1;


    public Combate(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;

        if (jugador1.getPokemonSeleccionado().getVelocidad() > jugador2.getPokemonSeleccionado().getVelocidad()) {
            this.esJugador1 = true;
        } else {
            this.esJugador1 = false;
        }
    }

    public void realizarAtaque() {
        int ataque;
        int defensa;
        if (esJugador1) {
            ataque = jugador1.getPokemonSeleccionado().getAtaque();
            defensa = jugador2.getPokemonSeleccionado().getDefensa();

        } else {
            ataque = jugador2.getPokemonSeleccionado().getAtaque();
            defensa = jugador1.getPokemonSeleccionado().getDefensa();
        }
        int result = ataque - defensa;

        cambiarTurno();
    }

    public void realizarDefensa() {


        cambiarTurno();
    }

    public void realizarHuida() {
        if (esJugador1) {
        // huye jugador 1
        } else {
       // huye juagdor 2
        }

    }


    private void cambiarTurno() {
        if (esJugador1) {
            esJugador1 = false;
        } else {
            esJugador1 = true;
        }

    }
}