package com.example.combatepokemon.Controllers;

import com.example.combatepokemon.Main.MyListener;
import com.example.combatepokemon.MainAplicacion;
import com.example.combatepokemon.Modelo.Jugador;
import com.example.combatepokemon.Modelo.Pokemon;
import com.example.combatepokemon.Modelo.ConversionPokemon;
import com.example.combatepokemon.Modelo.PokemonTipos;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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

    private int column = 0;
    private int row = 1;
    ConversionPokemon pokeColores = new ConversionPokemon();
    private Pokemon pokemonActual;
    private Jugador jugador;

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    private List<Pokemon> pokemonList = new ArrayList<>();

    protected Pokemon getPokemonActual() {
        return pokemonActual;
    }

    protected void setPokemonActual(Pokemon pokemonActual) {
        this.pokemonActual = pokemonActual;
    }

    private void generateTestData(MyListener callback) {


        Pokemon pikachu = new Pokemon(25, "Pikachu", PokemonTipos.ELECTRIC, 55, 40, 273, 90);
        Pokemon charizard = new Pokemon(6, "Charizard", PokemonTipos.FIRE, 84, 78, 330, 100);
        Pokemon blastoise = new Pokemon(9, "Blastoise", PokemonTipos.WATER, 83, 100, 400, 78);
        Pokemon venusaur = new Pokemon(3, "Venusaur", PokemonTipos.GRASS, 82, 83, 390, 80);
        Pokemon jolteon = new Pokemon(135, "Jolteon", PokemonTipos.ELECTRIC, 65, 60, 280, 130);
        Pokemon alakazam = new Pokemon(65, "Alakazam", PokemonTipos.PSYCHIC, 50, 45, 300, 120);
        Pokemon machamp = new Pokemon(68, "Machamp", PokemonTipos.FIGHTING, 130, 80, 340, 55);
        Pokemon lapras = new Pokemon(131, "Lapras", PokemonTipos.ICE, 85, 80, 130, 410);
        Pokemon aerodactyl = new Pokemon(142, "Aerodactyl", PokemonTipos.ROCK, 105, 65, 190, 130);
        pokemonList.add(pikachu);
        pokemonList.add(charizard);
        pokemonList.add(blastoise);
        pokemonList.add(venusaur);
        pokemonList.add(jolteon);
        pokemonList.add(alakazam);
        pokemonList.add(machamp);
        pokemonList.add(lapras);
        pokemonList.add(aerodactyl);


        for (int i = 0; i < pokemonList.size(); i++) {
            callback.onClickListener(pokemonList.get(i));
        }
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


        generateTestData(pokemon -> {

            try {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(MainAplicacion.class.getResource("itemPoke.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                itemPokeController itemController = fxmlLoader.getController();

                itemController.setData(pokemon, data -> {
                    setChosenPokemon(data);
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

        });
        if(jugador != null){
            seleccionJugador.setText(jugador.getNombre().toUpperCase().trim()+" ELIGE TU POKEMON");
        } else{
            seleccionJugador.setText("No ha pasado el jugador");
        }
        setChosenPokemon(pokemonList.get(0));
    }

  /*  @FXML
    private void agregarPokemonClick() {
        jugador.setPokemonSeleccionado(getPokemonActual());
    }

*/
    @Override
    public void setMaestroControler(MaestroController maestro) {

    }
}