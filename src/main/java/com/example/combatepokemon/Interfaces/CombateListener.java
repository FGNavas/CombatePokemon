package com.example.combatepokemon.Interfaces;

public interface CombateListener {
    void onAttackButtonClick();

    void onDefenseButtonClick();

    void onFleeButtonClick();

    void turnChange();

    void onAccionRealizada(String mensaje);
}
