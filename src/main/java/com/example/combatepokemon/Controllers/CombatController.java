package com.example.combatepokemon.Controllers;

import com.example.combatepokemon.Interfaces.CombateListener;
import com.example.combatepokemon.Interfaces.MyListener;
import com.example.combatepokemon.Modelo.Jugador;
import com.example.combatepokemon.Modelo.Pokemon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class CombatController implements Initializable {
    @FXML
    private Label enemyPokeNoum;

    @FXML
    private Label playerPokeNoum;
    @FXML
    private Label actualhealth;
    @FXML
    private Label maxHealth;

    @FXML
    private ProgressBar healthBarPlayer;
    @FXML
    private ProgressBar enemyhealthBar;
    @FXML
    private Label textMensage;

    @FXML
    private ImageView playerPkView;
    @FXML
    private ImageView enemypokeview;

    @FXML
    private Button attack;

    @FXML
    private Button defense;

    @FXML
    private Button flee;
    private CombateListener combateListener;

    private Pokemon pokemon1, pokemon2;
    private MyListener myListener;

    public void setData(Jugador jugador1, Jugador jugador2) {
        this.pokemon1 = jugador1.getPokemonSeleccionado();
        this.pokemon2 = jugador2.getPokemonSeleccionado();
        this.myListener = myListener;
        Image playerImg = new Image(getClass().getResourceAsStream("/ImagenesPoke/" + pokemon1.getId_poke() + "b.gif"));
        Image ememyImg = new Image(getClass().getResourceAsStream("/ImagenesPoke/" + pokemon2.getId_poke() + ".gif"));
        playerPkView.setImage(playerImg);
        enemypokeview.setImage(ememyImg);
        maxHealth.setText(String.valueOf(pokemon1.getVida()));
        actualhealth.setText(String.valueOf(pokemon1.getVida()));
        playerPokeNoum.setText(pokemon1.getNombre());
        enemyPokeNoum.setText(pokemon2.getNombre());


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myListener = (data) -> {
        };

    }

    public void setCombateListener(CombateListener listener) {
        this.combateListener = listener;
    }
    @FXML
    private void handleAttack(ActionEvent event) {

        if (combateListener != null) {
            combateListener.onAttackButtonClick();
        }
    }

    @FXML
    private void handleDefense(ActionEvent event) {

        if (combateListener != null) {
            combateListener.onDefenseButtonClick();
        }
    }

    @FXML
    private void handleFlee(ActionEvent event) {

        if (combateListener != null) {
            combateListener.onFleeButtonClick();
        }
    }
}

