package cc3002.trainer;

import cc3002.ICard;
import cc3002.pokemon.IPokemon;

import java.util.ArrayList;

/**
 * Interface for
 */
public interface ITrainer {

    String getName();
    ArrayList<ICard> getHand();
    void selectAttackOfActivePokemon(int option);
    IPokemon getActivePokemon();
    void changeActivePokemon(int option);
    boolean isOver();
    

}
