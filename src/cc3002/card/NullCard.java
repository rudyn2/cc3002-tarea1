package cc3002.card;

import cc3002.trainer.ITrainer;

public class NullCard implements ICard {
    /**
     * Getter for the card name.
     *
     * @return The card name.
     */
    @Override
    public String getName() {
        return "";
    }

    /**
     * Getter for a short information of the card.
     *
     * @return A String with the information of the card.
     */
    @Override
    public String getInfo() {
        return "";
    }

    /**
     * Method that plays an ICard. If the card is a pokemon, the pokemon will be added to the bench.
     * Is the card is an energy the energy will be added to the trainer active pokemon.
     *
     * @param trainer
     */
    @Override
    public void play(ITrainer trainer) {

    }
}
