package cc3002.trainercard;

import cc3002.effect.Effect;
import cc3002.trainer.ITrainer;

public abstract class AbstractTrainerCard implements ITrainerCard {

    private String name;
    private String info;
    private Effect effect;

    public AbstractTrainerCard(String name, Effect effect) {
        this.name = name;
        this.effect = effect;
    }

    /**
     * Getter for the card name.
     *
     * @return The card name.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Getter for a short information of the card.
     *
     * @return A String with the information of the card.
     */
    @Override
    public String getInfo() {
        return this.info;
    }

    public Effect getEffect() {
        return effect;
    }

    @Override
    public void play(ITrainer trainer) {
        trainer.addTrainerCardQueue(this);

    }

    /**
     * Method that plays an ICard. If the card is a pokemon, the pokemon will be added to the bench.
     * Is the card is an energy the energy will be added to the trainer active pokemon.
     *
     * @param trainer
     */
}
