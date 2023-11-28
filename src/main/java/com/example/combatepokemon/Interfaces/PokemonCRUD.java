package com.example.combatepokemon.Interfaces;

import com.example.combatepokemon.ExcepPersonalizadas.PokemonDuplicateEx;
import com.example.combatepokemon.ExcepPersonalizadas.PokemonNotFoundEx;
import com.example.combatepokemon.Modelo.Pokemon;

import java.util.List;

public interface PokemonCRUD {
    // Operación de lectura (Read)
    List<Pokemon> getAllPokemon();

    // Operación de lectura por ID (Read)
    Pokemon getPokemonById(int id) throws PokemonNotFoundEx;

    // Operacion de lectura por Nombre (Read)
    Pokemon getPokemonByName(String name) throws PokemonNotFoundEx;

    // Operación de creación (Create)
    void addPokemon(Pokemon newPokemon) throws PokemonDuplicateEx;

    // Operación de actualización (Update)
    void updatePokemon(Pokemon updatedPokemon) throws PokemonNotFoundEx;

    // Operación de eliminación (Delete)
    void deletePokemon(int id) throws PokemonNotFoundEx;
}