package cc3002.pokemon;

import cc3002.attack.IAttack;

import java.util.ArrayList;

public interface IPokemon {
    String getName();

    /**
     * Obtiene la cantidad de puntos del pokemon
     * @return puntos de vida del pokemon [int]
     */
    int getHp();
    boolean isDead();
    ArrayList<IAttack> getAttacks();

}
