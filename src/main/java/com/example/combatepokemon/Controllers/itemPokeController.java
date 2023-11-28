package com.example.combatepokemon.Controllers;
import com.example.combatepokemon.Main.MyListener;

import com.example.combatepokemon.MainAplicacion;
import com.example.combatepokemon.Modelo.Pokemon;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class itemPokeController implements Initializable {

    @FXML
    private Label pokemonLabel;

    @FXML private ImageView img;
    @FXML private ImageView logoPoke;
    @FXML private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(pokemon);
    }

    private Pokemon pokemon;
    private MyListener myListener;

    public void setData(Pokemon pokemon, MyListener myListener) {

        this.pokemon      = pokemon;
        this.myListener = myListener;
        Image image = new Image(getClass().getResourceAsStream("/ImagenesPoke/" + pokemon.getId_poke() + ".gif"));
        Image logo = new Image(getClass().getResourceAsStream("/TipoLogo/" + String.valueOf(pokemon.getTipo()).toLowerCase() + ".png"));
        pokemonLabel.setText(pokemon.getNombre());
        logoPoke.setImage(logo);

        img.setImage(image);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myListener = (data)->{};
    }
}
