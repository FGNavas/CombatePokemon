package com.example.combatepokemon.Controllers;

import com.example.combatepokemon.Interfaces.ControladorBase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class IntroController implements Initializable, ControladorBase {
    @FXML
    private TextField nombreJug1;

    @FXML
    private TextField nombreJug2;

    @FXML
    private Button siguienteButton;
    private MaestroController maestro;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    @Override
    public void setMaestroController(MaestroController maestro) {
        this.maestro = maestro;
    }

    public void nombresElegidos(MouseEvent mouseEvent) {
        String nombre1 = nombreJug1.getText();
        String nombre2 = nombreJug2.getText();

        maestro.registroJugadores(nombre1.trim().toUpperCase(), nombre2.toUpperCase().trim());

    }
}