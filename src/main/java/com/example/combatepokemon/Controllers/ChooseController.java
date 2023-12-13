package com.example.combatepokemon.Controllers;

import com.example.combatepokemon.Interfaces.ControladorBase;
import com.example.combatepokemon.Interfaces.PokemonSeleccionadoListener;
import com.example.combatepokemon.Interfaces.MyListener;
import com.example.combatepokemon.MainAplicacion;
import com.example.combatepokemon.Modelo.Pokemon;
import com.example.combatepokemon.Modelo.ConversionPokemon;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ChooseController implements Initializable, ControladorBase {
    @FXML
    private VBox pokemonSeleccionado;
    @FXML
    private Label nombrePokemon;
    @FXML
    private Label seleccionJugador;


    @FXML
    private ImageView pokemonIMG;
    @FXML
    private ImageView logoPokeCH;
    @FXML
    private Label ataqueVal;
    @FXML
    private Label defensaVal;
    @FXML
    private Label vidaVal;
    @FXML
    private Label velocidadVal;
    @FXML
    private GridPane grid;

    private List<Pokemon> pokemonList = new ArrayList<>();

    private int column = 0;
    private int row = 1;
    ConversionPokemon pokeColores = new ConversionPokemon();
    private Pokemon pokemonActual;

    private MaestroController maestroController;

    private PokemonSeleccionadoListener pokemonSeleccionadoListener;
    private String nombreJugador;

    public void setPokemonSeleccionadoListener(PokemonSeleccionadoListener listener) {
        this.pokemonSeleccionadoListener = listener;
    }


    @FXML
    private void onSeleccionarPokemonClick() {
        if (maestroController != null && getPokemonActual() != null) {
            maestroController.onPokemonSeleccionado(getPokemonActual());
        }

    }


    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        seleccionJugador.setText(nombreJugador.toUpperCase().trim() + " ELIGE TU POKEMON");
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;


        for (int i = 0; i < pokemonList.size(); i++) {
            addItem(pokemonList.get(i));
        }





    }

    private void addItem(Pokemon pokemon) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(MainAplicacion.class.getResource("itemPoke.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            itemPokeController itemController = fxmlLoader.getController();

            itemController.setData(pokemon, () -> {
                setChosenPokemon(pokemon);
            });

            if (column == 2) {
                column = 0;
                row++;
            }

            grid.add(anchorPane, column++, row); //(child,column,row)
            //set grid width
            grid.setMinWidth(Region.USE_COMPUTED_SIZE);
            grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
            grid.setMaxWidth(Region.USE_PREF_SIZE);

            //set grid height
            grid.setMinHeight(Region.USE_COMPUTED_SIZE);
            grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
            grid.setMaxHeight(Region.USE_PREF_SIZE);

            GridPane.setMargin(anchorPane, new Insets(10));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    protected Pokemon getPokemonActual() {
        return pokemonActual;
    }

    protected void setPokemonActual(Pokemon pokemonActual) {
        this.pokemonActual = pokemonActual;
    }


    private void setChosenPokemon(Pokemon pokemon) {

        nombrePokemon.setText(pokemon.getNombre());
        logoPokeCH.setImage(pokeColores.logoTipo(pokemon));
        pokemonIMG.setImage(pokeColores.imagenPokemon(pokemon));
        ataqueVal.setText(String.valueOf(pokemon.getAtaque()));
        defensaVal.setText(String.valueOf(pokemon.getDefensa()));
        vidaVal.setText(String.valueOf(pokemon.getVida()));
        velocidadVal.setText(String.valueOf(pokemon.getVelocidad()));

        pokemonSeleccionado.setStyle("-fx-background-color: #" + pokeColores.colorAsociado(pokemon));

        setPokemonActual(pokemon);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void setMaestroController(MaestroController maestro) {
        this.maestroController = maestro;
    }


}
