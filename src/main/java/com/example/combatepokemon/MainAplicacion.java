package com.example.combatepokemon;

import com.example.combatepokemon.Controllers.DataController;
import com.example.combatepokemon.Interfaces.ControladorBase;
import com.example.combatepokemon.Controllers.MaestroController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainAplicacion extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        // FXMLLoader fxmlLoader = new FXMLLoader(MainAplicacion.class.getResource("combat.fxml"));
        //  FXMLLoader fxmlLoader = new FXMLLoader(MainAplicacion.class.getResource("choose.fxml"));

        MaestroController maestroController = new MaestroController(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(MainAplicacion.class.getResource("intro.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        ControladorBase controladorBase = fxmlLoader.getController();
        controladorBase.setMaestroController(maestroController);


        stage.setTitle("Combate pokemon");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}