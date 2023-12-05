package com.example.combatepokemon.Modelo;

import com.example.combatepokemon.ExcepPersonalizadas.PokemonNotFoundEx;
import com.example.combatepokemon.Interfaces.PokemonCRUD;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager implements PokemonCRUD {
    private Connection connection;
    private Statement statement;

    // Ruta de la base de datos SQLite
    private final String RUTA = "jdbc:sqlite:src\\main\\resources\\";
    // Base de datos
    private final String DEFAULT_DB = "pokedex.db";
    // Sentencia de creacion de la tabla
    private final String POKEMON_TABLE = "CREATE TABLE IF NOT EXISTS pokemon (\n"
            + " id_numero INT NOT NULL,\n"
            + " nombre VARCHAR(50) NOT NULL,\n"
            + " tipoPrimario VARCHAR(15),\n"
            + " puntosSalud INT,\n"
            + " ataque INT,\n"
            + " defensa INT,\n"
            + " velocidad INT\n"
            + ");\n";

    // Sentencia para insertar nuevos pokemon
    private final String POKEMON_INSERT = "INSERT INTO pokemon (id_numero, nombre, tipoPrimario, puntosSalud," +
            " ataque, defensa, velocidad) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private final String POKEMON_SEARCH = "SELECT id_numero, nombre, tipoPrimario,  puntosSalud," +
            "ataque, defensa, velocidad FROM pokemon ORDER BY id_numero; ";
    private List<Pokemon> pokemonList;

    public DataManager() {
        this.pokemonList = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(RUTA+DEFAULT_DB);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Inicializa los datos, ya sea desde la base de datos o manualmente
        initializeData();
    }

    private void initializeData() {

        try (Statement createTable = connection.createStatement();
             ResultSet resul = createTable.executeQuery(POKEMON_TABLE)) {

        } catch (SQLException e) {

        }
        // Implementa la inicialización de datos aquí
        Pokemon pikachu = new Pokemon(25, "Pikachu", PokemonTipos.ELECTRIC, 55, 40, 273, 90);
        Pokemon charizard = new Pokemon(6, "Charizard", PokemonTipos.FIRE, 84, 78, 330, 100);
        Pokemon blastoise = new Pokemon(9, "Blastoise", PokemonTipos.WATER, 83, 100, 400, 78);
        Pokemon venusaur = new Pokemon(3, "Venusaur", PokemonTipos.GRASS, 82, 83, 390, 80);
        Pokemon jolteon = new Pokemon(135, "Jolteon", PokemonTipos.ELECTRIC, 65, 60, 280, 130);
        Pokemon alakazam = new Pokemon(65, "Alakazam", PokemonTipos.PSYCHIC, 50, 45, 300, 120);
        Pokemon machamp = new Pokemon(68, "Machamp", PokemonTipos.FIGHTING, 130, 80, 340, 55);
        Pokemon lapras = new Pokemon(131, "Lapras", PokemonTipos.ICE, 85, 80, 130, 410);
        Pokemon aerodactyl = new Pokemon(142, "Aerodactyl", PokemonTipos.ROCK, 105, 65, 190, 130);
        ;
        pokemonList= getAllPokemon();
        if(pokemonList.isEmpty()) {
            addPokemon(pikachu);
            addPokemon(charizard);
            addPokemon(blastoise);
            addPokemon(venusaur);
            addPokemon(jolteon);
            addPokemon(alakazam);
            addPokemon(machamp);
            addPokemon(lapras);
            addPokemon(aerodactyl);
        }

    }

    @Override
    public List<Pokemon> getAllPokemon() {

        // Implementa la operación de lectura (Read)
        try (Statement allPokeState = connection.createStatement();
             ResultSet resultado = allPokeState.executeQuery(POKEMON_SEARCH)) {
            while (resultado.next()) {
                int id_numero = resultado.getInt("id_numero");
                String nombre = resultado.getString("nombre");
                String tipoPrimario = resultado.getString("tipoPrimario");
                PokemonTipos tipo = PokemonTipos.valueOf(tipoPrimario.toUpperCase());
                int ataque = resultado.getInt("ataque");
                int defensa = resultado.getInt("defensa");
                int vida = resultado.getInt("puntosSalud");
                int velocidad = resultado.getInt("velocidad");
                Pokemon pokemon = new Pokemon(id_numero, nombre, tipo, ataque, defensa, vida, velocidad);
                pokemonList.add(pokemon);

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return pokemonList;
    }

    @Override
    public Pokemon getPokemonById(int id) {
        // Implementa la operación de lectura por ID (Read)
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Pokemon getPokemonByName(String name) throws PokemonNotFoundEx {
        // Implementa la operación de lectura por nombre (Read)
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void addPokemon(Pokemon newPokemon) {
        // Implementa la operación de creación (Create), no se tiene en cuenta los repetidos, solo se estan metiendo
        // los datos a piñon
        try (PreparedStatement insertPoke = connection.prepareStatement(POKEMON_INSERT)) {
            insertPoke.setInt(1, newPokemon.getId_poke());
            insertPoke.setString(2, newPokemon.getNombre());
            insertPoke.setString(3, String.valueOf(newPokemon.getTipo()));
            insertPoke.setInt(4, newPokemon.getVida());
            insertPoke.setInt(5, newPokemon.getAtaque());
            insertPoke.setInt(6, newPokemon.getDefensa());
            insertPoke.setInt(7, newPokemon.getVelocidad());
            insertPoke.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void updatePokemon(Pokemon updatedPokemon) {
        // Implementa la operación de actualización (Update)
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void deletePokemon(int id) {
        // Implementa la operación de eliminación (Delete)
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
