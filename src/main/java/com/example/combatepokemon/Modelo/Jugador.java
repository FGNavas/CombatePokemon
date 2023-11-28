package com.example.combatepokemon.Modelo;

public class Jugador {

    private String nombre;

    private Pokemon pokemonSeleccionado;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public Jugador(String nombre, Pokemon pokemonSeleccionado) {
        this.nombre = nombre;
        this.pokemonSeleccionado = pokemonSeleccionado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pokemon getPokemonSeleccionado() {
        return pokemonSeleccionado;
    }

    public void setPokemonSeleccionado(Pokemon pokemonSeleccionado) {
        this.pokemonSeleccionado = pokemonSeleccionado;
    }
}
