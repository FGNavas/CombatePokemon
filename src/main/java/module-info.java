module com.example.combatepokemon {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.combatepokemon to javafx.fxml;
    exports com.example.combatepokemon;
    exports com.example.combatepokemon.Controllers;
    opens com.example.combatepokemon.Controllers to javafx.fxml;
    exports com.example.combatepokemon.Modelo;
    opens com.example.combatepokemon.Modelo to javafx.fxml;
}