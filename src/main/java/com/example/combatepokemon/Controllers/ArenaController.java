package com.example.combatepokemon.Controllers;

import com.example.combatepokemon.Interfaces.ControladorBase;
import com.example.combatepokemon.MainAplicacion;
import com.example.combatepokemon.Modelo.Combate;
import com.example.combatepokemon.Modelo.Jugador;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ArenaController implements Initializable, ControladorBase {

    @FXML
    private Label player1Name;

    @FXML
    private Label player2name;
    @FXML
    private AnchorPane player1stage;

    @FXML
    private AnchorPane player2stage;

    private MaestroController maestroController;
    private Combate combate;

    public void setCombates(Jugador jug1, Jugador jug2) {
        player1Name.setText(jug1.getNombre());
        player2name.setText(jug2.getNombre());
        player1Name.setText(jug1.getNombre());
        player2name.setText(jug2.getNombre());
        cargarVentanaCombate(jug1, jug2, player1stage, "player1");
        cargarVentanaCombate(jug2, jug1, player2stage, "player2");
    }

    public void setCombate(Combate combate) {
        this.combate = combate;
    }
    @Override
    public void setMaestroController(MaestroController maestro) {
        this.maestroController = maestro;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void cargarVentanaCombate(Jugador jug1, Jugador jug2, AnchorPane anchorPane, String identificador) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainAplicacion.class.getResource("combat.fxml"));
            AnchorPane combatePane = fxmlLoader.load();
            CombatController combatController = fxmlLoader.getController();

            combatController.setData(jug1, jug2);


            anchorPane.getChildren().add(combatePane);
            combatePane.setId(identificador);

        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}
