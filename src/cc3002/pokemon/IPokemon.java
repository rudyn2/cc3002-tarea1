package cc3002.pokemon;

import cc3002.attack.*;
import cc3002.card.ICard;
import cc3002.energy.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Common interface for a generic pokemon. Each pokemon has to be able to attack other pokemon and
 * receive attack, select attacks and a set of multiples getters for get information about its status.
 * By other side, it needs to be able to receive energy for the execution of the attacks.
 * @author Rudy García Alvarado
 */
public interface IPokemon extends ICard{

    /**
     * Getter fort the hit points ot the pokemon.
     * @return The pokemon hit points (hp).
     */
    int getHp();

    /** Method for make an specific damage to the pokemon.
     * @param damage An amount of damage.
     */
    void makeDamage(int damage);
    void heal(int points);
    /** Check if the pokemon is death.
     * @return True if the pokemon is death.
     */
    boolean isDead();

    /**
     * Getter for the id of the pokemon.
     * @return The id of the pokemon.
     */
    int getId();

    boolean checkEnergy();


    /** Getter for the available energies.
     * @return A HashMap which keys are the energy type and its values are a list with the available energies.
     */
    HashMap<String, ArrayList<IEnergy>> getEnergyHash();

    /** Getter for the pokemon attacks.
     * @return An ArrayList with the pokemon IAttack's.
     */
    ArrayList<IAbility> getAbilities();
    ArrayList<IAttack> getAttacks();

    /** Method to select an attack from a position.
     * @param option Integer position of the wanted attack.
     */
    void selectAttack(int option);
    void selectAbility(int option);

    /** Method to attack a pokemon.
     * @param target Pokemon that will be attacked.
     */
    void useAttack(IPokemon target);
    IAbility useAbility();

    /** Getter to the pokemon selected attack.
     * @return The selected attack.
     */
    IAbility getSelectedAbility();
    IAttack getSelectedAttack();

    /** Method to receive a FireEnergy to and include it into the availableEnergy.
     * @param fireEnergy A FireEnergy.
     */
    void receiveFireEnergy(FireEnergy fireEnergy);

    /** Method to receive a ElectricEnergy to and include it into the availableEnergy.
     * @param electricEnergy A ElectricEnergy.
     */
    void receiveElectricEnergy(ElectricEnergy electricEnergy);


    /** Method to receive a FighterEnergy to and include it into the availableEnergy.
     * @param fighterEnergy A FighterEnergy.
     */
    void receiveFighterEnergy(FighterEnergy fighterEnergy);


    /** Method to receive a GrassEnergy to and include it into the availableEnergy.
     * @param grassEnergy A GrassEnergy.
     */
    void receiveGrassEnergy(GrassEnergy grassEnergy);

    /** Method to receive a PsychicEnergy to and include it into the availableEnergy.
     * @param psychicEnergy A PsychicEnergy.
     */
    void receivePsychicEnergy(PsychicEnergy psychicEnergy);

    /** Method to receive a WaterEnergy to and include it into the availableEnergy.
     * @param waterEnergy A WaterEnergy.
     */
    void receiveWaterEnergy(WaterEnergy waterEnergy);


    /** Method to receive a FireAttack and make damage to the pokemon.
     * @param fireAttack A FireAttack.
     */
    void receiveFireAttack(FireAttack fireAttack);

    /** Method to receive a ElectricAttack and make damage to the pokemon.
     * @param electricAttack A ElectricAttack.
     */
    void receiveElectricAttack(ElectricAttack electricAttack);

    /** Method to receive a FighterAttack and make damage to the pokemon.
     * @param fighterAttack A FighterAttack.
     */
    void receiveFighterAttack(FighterAttack fighterAttack);

    /** Method to receive a GrassAttack and make damage to the pokemon.
     * @param grassAttack A GrassAttack.
     */
    void receiveGrassAttack(GrassAttack grassAttack);


    /** Method to receive a PsychicAttack and make damage to the pokemon.
     * @param psychicAttack A PsychicAttack.
     */
    void receivePsychicAttack(PsychicAttack psychicAttack);

    /** Method to receive a WaterAttack and make damage to the pokemon.
     * @param waterAttack A WaterAttack.
     */
    void receiveWaterAttack(WaterAttack waterAttack);

    boolean checkBasic();
    boolean checkS1();
    boolean checkS2();

}
