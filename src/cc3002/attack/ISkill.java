package cc3002.attack;

import cc3002.pokemon.*;

public interface ISkill {

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
     * Method to check if the specified FirePokemon has enough fire energies.
     * @param pokemon The pokemon that will be reviewed.
     * @return True if the specified pokemon can perform the attack according its available energies.
     */
    boolean checkFireEnergy(AbstractFirePokemon pokemon);

    /**
     * Method to check if the specified ElectricPokemon has enough electric energies.
     * @param pokemon The pokemon that will be reviewed.
     * @return True if the specified pokemon can perform the attack according its available energies.
     */
    boolean checkElectricEnergy(AbstractElectricPokemon pokemon);

    /**
     * Method to check if the specified FighterPokemon has enough fighter energies.
     * @param pokemon The pokemon that will be reviewed.
     * @return True if the specified pokemon can perform the attack according its available energies.
     */
    boolean checkFighterEnergy(AbstractFighterPokemon pokemon);

    /**
     * Method to check if the specified GrassPokemon has enough grass energies.
     * @param pokemon The pokemon that will be reviewed.
     * @return True if the specified pokemon can perform the attack according its available energies.
     */
    boolean checkGrassEnergy(AbstractGrassPokemon pokemon);

    /**
     * Method to check if the specified PsychicPokemon has enough psychic energies.
     * @param pokemon The pokemon that will be reviewed.
     * @return True if the specified pokemon can perform the attack according its available energies.
     */
    boolean checkPsychicEnergy(AbstractPsychicPokemon pokemon);

    /**
     * Method to check if the specified WaterPokemon has enough water energies.
     * @param pokemon The pokemon that will be reviewed.
     * @return True if the specified pokemon can perform the attack according its available energies.
     */
    boolean checkWaterEnergy(AbstractWaterPokemon pokemon);

}
