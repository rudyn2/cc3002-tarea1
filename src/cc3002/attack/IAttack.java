package cc3002.attack;

import cc3002.pokemon.*;
import cc3002.visitor.IVisitor;

/**
 * Common interface for the generic attack. "The attack attacks the pokemon". Every attack has a name,
 * description, base damage and a cost. It also needs to be able to check if some pokemon can use it.
 * @author Rudy García Alvarado
 */
public interface IAttack extends ISkill {

    /**
     * Method to attack a pokemon. "The attack attacks the specified pokemon".
     * @param pokemon Pokemon that will be attacked.
     */
    void attack(IPokemon pokemon);


    /**
     * Getter for the cost of the attack.
     * @return An integer that represents the cost of the attack.
     */
    int getCost();


    /**
     * Getter for the base damage of the attack.
     * @return An integer that represents the damage that the attack can make.
     */
    int getBaseDamage();

}
