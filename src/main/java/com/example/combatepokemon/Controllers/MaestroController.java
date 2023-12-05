package com.example.combatepokemon.Controllers;


import com.example.combatepokemon.Interfaces.PokemonSeleccionadoListener;
import com.example.combatepokemon.MainAplicacion;
import com.example.combatepokemon.Modelo.Combate;
import com.example.combatepokemon.Modelo.DataManager;
import com.example.combatepokemon.Modelo.Jugador;
import com.example.combatepokemon.Modelo.Pokemon;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class MaestroController implements PokemonSeleccionadoListener {

    public Jugador jugador1;
    public Jugador jugador2;
    protected List<Pokemon> listPokemon;
    private Stage stageActual;
    private DataManager dataManager;

    private Combate combate;
    public MaestroController(Stage stage) {
        this.stageActual = stage;
        jugador1 = new Jugador("", null);
        jugador2 = new Jugador("", null);
        dataManager = new DataManager();
        listPokemon = dataManager.getAllPokemon();

    }

    public void setStageActual(Stage stageActual) {
        this.stageActual = stageActual;
    }

    public List<Pokemon> getListPokemon() {
        return listPokemon;
    }

    public void setListPokemon(List<Pokemon> listPokemon) {
        this.listPokemon = listPokemon;
    }

    public void registroJugadores(String nombre1, String nombre2) {


        if (nombre1.equals("")) {
            nombre1 = "RED";
        }
        if (nombre2.equals("") || nombre2.equals(nombre1)) {
            nombre2 = "BLUE";
        }


        jugador1.setNombre(nombre1);
        jugador2.setNombre(nombre2);

        ventanaSeleccion(jugador1, listPokemon);


    }


    public void ventanaSeleccion(Jugador jugador, List<Pokemon> lista) {


        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainAplicacion.class.getResource("choose.fxml"));

            Parent vista = fxmlLoader.load();
            ChooseController controladorVentana = fxmlLoader.getController();
            controladorVentana.setPokemonList(lista);
            controladorVentana.setMaestroController(this);
            controladorVentana.setPokemonSeleccionadoListener(this);

            Scene escena = new Scene(vista);

            stageActual.setScene(escena);
            stageActual.show();

            controladorVentana.setNombreJugador(jugador.getNombre());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onPokemonSeleccionado(Pokemon pokemon) {
        if (jugador1.getPokemonSeleccionado() == null) {

            jugador1.setPokemonSeleccionado(pokemon);

        } else {

            jugador2.setPokemonSeleccionado(pokemon);

        }
        if (jugador2.getPokemonSeleccionado() == null) {

            ventanaSeleccion(jugador2, listPokemon);


        }
        if (jugador1.getPokemonSeleccionado() != null && jugador2.getPokemonSeleccionado() != null) {
            inicioVentanaCombate(jugador1, jugador2);
        }
    }

    private void inicioVentanaCombate(Jugador jugador1, Jugador jugador2) {


        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainAplicacion.class.getResource("arena.fxml"));

            Parent vista = fxmlLoader.load();
            ArenaController arenaController = fxmlLoader.getController();
            arenaController.setCombates(jugador1, jugador2);
            arenaController.setMaestroController(this);

            combate = new Combate(jugador1, jugador2);
            arenaController.setCombate(combate);

            Scene escena = new Scene(vista);
            stageActual.setTitle("Combate: " + jugador1.getNombre() + " VS " + jugador2.getNombre());
            stageActual.setScene(escena);
            stageActual.show();

            combatePokemon();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    private void combatePokemon() {
        // Lógica para gestionar el combate utilizando la clase Combate
        // Puedes llamar a métodos en la instancia de Combate según las acciones del usuario
        // Por ejemplo: combate.realizarAtaque(), combate.realizarDefensa(), etc.
    }

}
