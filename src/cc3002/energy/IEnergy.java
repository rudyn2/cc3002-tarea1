package cc3002.energy;

import cc3002.ICard;
import cc3002.pokemon.IPokemon;

public interface IEnergy extends ICard{

    /** Getter for the base energy of the energy card.
     * @return An integer with the base energy.
     */
    int getBaseEnergy();


    /** Method to assign an energy to the provided pokemon.
     * @param pokemon Pokemon which will receive the energy.
     */
    void assignEnergy(IPokemon pokemon);

}
