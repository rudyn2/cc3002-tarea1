package cc3002.attack;

import cc3002.energy.IEnergy;
import cc3002.pokemon.*;

import java.util.ArrayList;

/**
 * Abstract class that represents a generic attack. It provides minimal methods to implement
 * the basics attacks actions like check if it could be made or getter for the name. The attack action
 * is implemented in its subclasses.
 * @author Rudy García Alvaradi
 */
public abstract class AbstractAttack implements IAttack {

    /**
     * Name of the attack.
     */
    private String name;


    /**
     * Description of the attack. Example: a big and amazing ball of fire.
     */
    private String description;


    /**
     * Base damage of the attack.
     */
    private int baseDamage;

    /**
     * Cost of the attack.
     */
    private int cost;


    /**
     * Abstract constructor for a generic attack.
     * @param name The name of the attack.
     * @param description The description of the attack.
     * @param baseDamage The base damage of the attack.
     * @param cost The cost of the attack.
     */
    AbstractAttack(String name, String description, int baseDamage, int cost){
        this.name = name;
        this.description = description;
        this.baseDamage = baseDamage;
        this.cost = cost;
    }


    /**
     * Getter for the name of the attack.
     * @return The name of the attack.
     */
    @Override
    public String getName() {
        return this.name;
    }


    /**
     * Getter for the cost of the attack.
     * @return The cost of the attack.
     */
    @Override
    public int getCost() {
        return this.cost;
    }

    /**
     * Getter for the description of the attack.
     * @return The description of the attack.
     */
    @Override
    public String getDescription(){
        return this.description;
    }

    /**
     * Getter for the base damage of the attack.
     * @return The base damage of the attack.
     */
    @Override
    public int getBaseDamage() {
        return this.baseDamage;
    }

    /**
     * Method to count the total energies of some ArrayList of energies.
     * @param energies An ArrayList with IEnergies.
     * @return The sum of the base energy of each energy.
     */
    private int countEnergy(ArrayList<IEnergy> energies){
        int energyCount = 0;
        if (energies.size() > 0) {
            for(IEnergy e : energies) {
                energyCount += e.getBaseEnergy();
            }
        }
        return energyCount;
    }

    /**
     * Check if the specified FirePokemon can perform this attack.
     * @param pokemon The FirePokemon that will be reviewed.
     * @return True if the FirePokemon has more or equal amount of energy than the cost of the attack.
     */
    @Override
    public boolean checkFireEnergy(AbstractFirePokemon pokemon) {
        ArrayList<IEnergy> energies = pokemon.energyAvailable.get("FireEnergies");
        return this.countEnergy(energies) >= this.cost;

    }

    /**
     * Check if the specified ElectricPokemon can perform this attack.
     * @param pokemon The ElectricPokemon that will be reviewed.
     * @return True if the ElectricPokemon has more or equal amount of energy than the cost of the attack.
     */
    @Override
    public boolean checkElectricEnergy(AbstractElectricPokemon pokemon) {
        ArrayList<IEnergy> energies = pokemon.energyAvailable.get("ElectricEnergies");
        return this.countEnergy(energies) >= this.cost;
    }

    /**
     * Check if the specified FighterPokemon can perform this attack.
     * @param pokemon The FighterPokemon that will be reviewed.
     * @return True if the FighterPokemon has more or equal amount of energy than the cost of the attack.
     */
    @Override
    public boolean checkFighterEnergy(AbstractFighterPokemon pokemon) {
        ArrayList<IEnergy> energies = pokemon.energyAvailable.get("FighterEnergies");
        return this.countEnergy(energies) > this.cost;
    }

    /**
     * Check if the specified GrassPokemon can perform this attack.
     * @param pokemon The GrassPokemon that will be reviewed.
     * @return True if the GrassPokemon has more or equal amount of energy than the cost of the attack.
     */
    @Override
    public boolean checkGrassEnergy(AbstractGrassPokemon pokemon) {
        ArrayList<IEnergy> energies = pokemon.energyAvailable.get("GrassEnergies");
        return this.countEnergy(energies) > this.cost;
    }

    /**
     * Check if the specified PsychicPokemon can perform this attack.
     * @param pokemon The PsychicPokemon that will be reviewed.
     * @return True if the PsychicPokemon has more or equal amount of energy than the cost of the attack.
     */
    @Override
    public boolean checkPsychicEnergy(AbstractPsychicPokemon pokemon) {
        ArrayList<IEnergy> energies = pokemon.energyAvailable.get("PsychicEnergies");
        return this.countEnergy(energies) > this.cost;
    }

    /**
     * Check if the specified WaterPokemon can perform this attack.
     * @param pokemon The WaterPokemon that will be reviewed.
     * @return True if the WaterPokemon has more or equal amount of energy than the cost of the attack.
     */
    @Override
    public boolean checkWaterEnergy(AbstractWaterPokemon pokemon) {
        ArrayList<IEnergy> energies = pokemon.energyAvailable.get("WaterEnergies");
        return this.countEnergy(energies) > this.cost;
    }


}
