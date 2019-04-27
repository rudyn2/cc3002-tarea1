package cc3002.energy;

import cc3002.card.ICard;
import cc3002.pokemon.IPokemon;

/**
 * Common interface for all the possibles energies. Every energy can be assigned to a pokemon
 * and needs to have a base energy and a name.
 * @author Rudy García Alvarado
 */
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
