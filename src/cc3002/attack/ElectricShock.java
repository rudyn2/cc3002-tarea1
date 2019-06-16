package cc3002.attack;

import cc3002.pokemon.IPokemon;

public class ElectricShock extends AbstractAttack {
    /**
     * Abstract constructor for a generic attack.
     *
     * @param name        The name of the attack.
     * @param description The description of the attack.
     * @param baseDamage  The base damage of the attack.
     * @param cost        The cost of the attack.
     */
    ElectricShock(String name, String description, int baseDamage, int cost) {
        super(name, description, baseDamage, cost);
    }


    /**
     * Method to attack a pokemon. "The attack attacks the specified pokemon".
     *
     * @param pokemon Pokemon that will be attacked.
     */
    @Override
    public void attack(IPokemon pokemon) {
        double random = Math.random();
        if (random >= 0.5){
            pokemon.makeDamage(getBaseDamage());
        }


    }
}
