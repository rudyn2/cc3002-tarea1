package cc3002.bench;

import cc3002.pokemon.IPokemon;

/**
 * The interface for a generic bench. The main aim of this interface is to define a
 * bench that helps a trainer to take a decision over its inactive pokemon. A trainer
 * should be able to add, remove, change, visualize, count or replace a pokemon in the bench.
 * @author Rudy García Alvarado
 */
public interface IBench {

    /**
     * Method to add a pokemon into the bench. Only if the bench isn't full.
     * @param pokemon The pokemon that will be added.
     */
    void add(IPokemon pokemon);

    /**
     * Method to remove a pokemon from the bench.
     * @param option The position of the pokemon that will be removed.
     */
    void remove(int option);

    /**
     * Method to replace a pokemon in the bench.
     * @param option The position of the pokemon that will be replaced.
     * @param pokemon The pokemon that will take place in the bench.
     * @return The pokemon that was in the place specified in the option.
     */
    IPokemon replace(int option, IPokemon pokemon);

    /**
     * Method that returns and remove the last pokemon in the bench.
     * @return The last pokemon in the bench.
     */
    IPokemon pop();

    /**
     * Method that counts the number of pokemon's that are in the bench.
     * @return The number of pokemon's in the bench.
     */
    int count();

    /**
     * Method to visualize the pokemon's in the bench. It will print
     * the position and the name of the pokemon in the bench.
     */
    void visualize();

    /**
     * Method that checks if the bench is empty.
     * @return True if the bench is empty.
     */
    boolean isEmpty();

    /**
     * Method that checks if the bench is full.
     * @return True if the bench is full.
     */
    boolean isFull();


}
