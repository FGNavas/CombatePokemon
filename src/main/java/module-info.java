module com.example.combatepokemon {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.combatepokemon to javafx.fxml;
    exports com.example.combatepokemon;
    exports com.example.combatepokemon.Controllers;
    opens com.example.combatepokemon.Controllers to javafx.fxml;
    exports com.example.combatepokemon.Modelo;
    opens com.example.combatepokemon.Modelo to javafx.fxml;
    exports com.example.combatepokemon.Interfaces;
    opens com.example.combatepokemon.Interfaces to javafx.fxml;
}