package cc3002.attack;

import cc3002.pokemon.*;

/**
 * Common interface for the generic attack. "The attack attacks the pokemon". Every attack has a name,
 * description, base damage and a cost. It also needs to be able to check if some pokemon can use it.
 */
public interface IAttack {

    /**
     * Method to attack a pokemon. "The attack attacks the specified pokemon".
     * @param pokemon Pokemon that will be attacked.
     */
    void attack(IPokemon pokemon);


    /**
     * Getter for the description of the attack.
     * @return The description of the attack.
     */
    String getDescription();


    /**
     * Getter for the name of the attack.
     * @return The name of the attack.
     */
    String getName();


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

    /**
     * Method to check if the specified FirePokemon has enough fire energies.
     * @param pokemon The pokemon that will be reviewed.
     * @return True if the specified pokemon can perform the attack according its available energies.
     */
    boolean checkFireEnergy(FirePokemon pokemon);

    /**
     * Method to check if the specified ElectricPokemon has enough electric energies.
     * @param pokemon The pokemon that will be reviewed.
     * @return True if the specified pokemon can perform the attack according its available energies.
     */
    boolean checkElectricEnergy(ElectricPokemon pokemon);

    /**
     * Method to check if the specified FighterPokemon has enough fighter energies.
     * @param pokemon The pokemon that will be reviewed.
     * @return True if the specified pokemon can perform the attack according its available energies.
     */
    boolean checkFighterEnergy(FighterPokemon pokemon);

    /**
     * Method to check if the specified GrassPokemon has enough grass energies.
     * @param pokemon The pokemon that will be reviewed.
     * @return True if the specified pokemon can perform the attack according its available energies.
     */
    boolean checkGrassEnergy(GrassPokemon pokemon);

    /**
     * Method to check if the specified PsychicPokemon has enough psychic energies.
     * @param pokemon The pokemon that will be reviewed.
     * @return True if the specified pokemon can perform the attack according its available energies.
     */
    boolean checkPsychicEnergy(PsychicPokemon pokemon);

    /**
     * Method to check if the specified WaterPokemon has enough water energies.
     * @param pokemon The pokemon that will be reviewed.
     * @return True if the specified pokemon can perform the attack according its available energies.
     */
    boolean checkWaterEnergy(WaterPokemon pokemon);
}
