package cc3002.card;

import cc3002.trainer.ITrainer;

/**
 * Common interface for every possible card. The game has pokemon and energies, both are cards.
 * Every card has a name.
 * @author Rudy García Alvarado
 */
public interface ICard {


    /** Getter for the card name.
     * @return The card name.
     */
    String getName();

    /**
     * Getter for a short information of the card.
     * @return A String with the information of the card.
     */
    String getInfo();

    /**
     * Method that plays an ICard. If the card is a pokemon, the pokemon will be added to the bench.
     * Is the card is an energy the energy will be added to the trainer active pokemon.
     */
    void play(ITrainer trainer);




}
