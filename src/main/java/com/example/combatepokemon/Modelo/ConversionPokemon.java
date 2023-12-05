package com.example.combatepokemon.Modelo;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class ConversionPokemon {


    private Map<PokemonTipos, String> tiposColores;

    public ConversionPokemon() {

        tiposColores = new HashMap<>();
        tiposColores.put(PokemonTipos.NORMAL, "808080"); // Gris
        tiposColores.put(PokemonTipos.FIRE, "e60000"); // Rojo
        tiposColores.put(PokemonTipos.WATER, "0066ff"); // Azul
        tiposColores.put(PokemonTipos.ELECTRIC, "ff9900"); // Amarillo
        tiposColores.put(PokemonTipos.GRASS, "008000"); // Verde
        tiposColores.put(PokemonTipos.ICE, "00bfff"); // Cian
        tiposColores.put(PokemonTipos.FIGHTING, "8B4513"); // Marrón
        tiposColores.put(PokemonTipos.POISON, "800080"); // Morado
        tiposColores.put(PokemonTipos.GROUND, "A52A2A"); // Marrón oscuro
        tiposColores.put(PokemonTipos.FLYING, "87CEEB"); // Celeste
        tiposColores.put(PokemonTipos.PSYCHIC, "FF69B4"); // Rosado
        tiposColores.put(PokemonTipos.BUG, "00FF00"); // Verde claro
        tiposColores.put(PokemonTipos.ROCK, "A9A9A9"); // Gris oscuro
        tiposColores.put(PokemonTipos.GHOST, "8A2BE2"); // Violeta
        tiposColores.put(PokemonTipos.DRAGON, "00008B"); // Azul oscuro
        tiposColores.put(PokemonTipos.DARK, "000000"); // Negro
        tiposColores.put(PokemonTipos.STEEL, "A9A9A9"); // Gris metálico
        tiposColores.put(PokemonTipos.FAIRY, "FFC0CB"); // Rosa

    }

    public String colorAsociado(Pokemon pokemon) {

        return tiposColores.get(pokemon.getTipo());
    }

    public Image imagenPokemon(Pokemon pokemon) {

        Image image = new Image(getClass().getResourceAsStream("/ImagenesPoke/" + pokemon.getId_poke() + ".gif"));

        return image;
    }


    public Image logoTipo(Pokemon pokemon) {
        Image logo = new Image(getClass().getResourceAsStream("/TipoLogo/" + String.valueOf(pokemon.getTipo()).toLowerCase() + ".png"));
        return logo;
    }

}
