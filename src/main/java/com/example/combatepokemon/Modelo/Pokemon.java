package com.example.combatepokemon.Modelo;

public class Pokemon {
    private int id_poke;
    private String nombre;
    private PokemonTipos tipo;
    private int ataque;
    private int defensa;
    private int vida;
    private int velocidad;

    public Pokemon(int id_poke, String nombre, PokemonTipos tipo, int ataque, int defensa, int vida, int velocidad) {
        this.id_poke = id_poke;
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.vida = vida;
        this.velocidad = velocidad;
    }


    public int getId_poke() {
        return id_poke;
    }

    public void setId_poke(int id_poke) {
        this.id_poke = id_poke;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public PokemonTipos getTipo() {
        return tipo;
    }

    public void setTipo(PokemonTipos tipo) {
        this.tipo = tipo;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
}
