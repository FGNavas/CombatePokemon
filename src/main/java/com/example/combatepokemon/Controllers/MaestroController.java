package com.example.combatepokemon.Controllers;


import com.example.combatepokemon.Interfaces.PokemonSeleccionadoListener;
import com.example.combatepokemon.MainAplicacion;
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
    private DataController dataController;


    public MaestroController(Stage stage) {
        this.stageActual = stage;
        jugador1 = new Jugador("",null);
        jugador2 = new Jugador("",null);
        dataController = new DataController();
        listPokemon= dataController.getAllPokemon();
    }

    public void setStageActual(Stage stageActual) {
        this.stageActual = stageActual;
    }

    public List<Pokemon> getListPokemon() {
        return listPokemon;
    }

    public void registroJugadores(String nombre1, String nombre2) {


        if (nombre1.equals("")) {
            nombre1 = "BLUE";
        }
        if (nombre2.equals("") || nombre2.equals(nombre1)) {
            nombre2 = "RED";
        }

        System.out.println(nombre1 + " " + nombre2);
        jugador1.setNombre(nombre1);
        jugador2.setNombre(nombre2);

        System.out.println("Cantidad de Pokémon en la lista en MaestroController: " + listPokemon.size());
        ventanaSeleccion(jugador1,listPokemon);


    }


    public void ventanaSeleccion(Jugador jugador, List<Pokemon> lista) {


        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainAplicacion.class.getResource("choose.fxml"));

            Parent vista = fxmlLoader.load();
            ChooseController controladorVentana = fxmlLoader.getController();

            controladorVentana.setMaestroController(this);
            controladorVentana.setPokemonSeleccionadoListener(this);

            Scene escena = new Scene(vista);

            stageActual.setScene(escena);
            stageActual.show();

            controladorVentana.setPokemonList(lista);
            controladorVentana.setNombreJugador(jugador.getNombre());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onPokemonSeleccionado(Pokemon pokemon) {
        if(jugador1.getPokemonSeleccionado()==null) {
            System.out.println("pokemon para jugador 1");
            jugador1.setPokemonSeleccionado(pokemon);
            System.out.println(jugador1.getPokemonSeleccionado().getNombre());
        } else{
            System.out.println("Selecciona pokemon para jugador 2");
            jugador2.setPokemonSeleccionado(pokemon);
            System.out.println(jugador2.getPokemonSeleccionado().getNombre());
        }
        if(jugador2.getPokemonSeleccionado()==null){
            System.out.println("Entra aqui para que coja el jugador 2");
            ventanaSeleccion(jugador2,listPokemon);
            /** De aqui al combate */
        }
    }
}
