package com.example.combatepokemon.Controllers;

import com.example.combatepokemon.MainAplicacion;
import com.example.combatepokemon.Modelo.Jugador;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MaestroController {

    public Jugador jugador1;
    public Jugador jugador2;
    private Stage stageActual;

    public MaestroController(Stage stage) {
        this.stageActual = stage;
        jugador1 = new Jugador("");
        jugador2 = new Jugador("");
    }

    public void setStageActual(Stage stageActual) {
        this.stageActual = stageActual;
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

        System.out.println(jugador1.getNombre());
        System.out.println(jugador2.getNombre());
        ventanaSeleccion(jugador1);


    }


    public void ventanaSeleccion(Jugador jugador) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainAplicacion.class.getResource("choose.fxml"));

            Parent vista = fxmlLoader.load();
            ChooseController controladorVentana = fxmlLoader.getController();
            controladorVentana.setMaestroControler(this);
            controladorVentana.setJugador(jugador);


            Scene escena = new Scene(vista);

            stageActual.setScene(escena);
            stageActual.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
