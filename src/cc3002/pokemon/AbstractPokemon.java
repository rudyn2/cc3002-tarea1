package cc3002.pokemon;

import cc3002.attack.*;
import cc3002.energy.*;
import cc3002.trainer.ITrainer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Abstract class that represent a pokemon. It defines a lot of common functionality about the pokemon's stuffs.
 * It stores some important fields like the hit points (hp) or the name. It defines an abstract constructor from
 * which the subclass will be instantiated.
 * @author Rudy García Alvarado
 */
public abstract class AbstractPokemon implements IPokemon {

    /**
     * Hit points ot the pokemon, in other terms, its life points.
     */
    private int hp;
    /**
     * Name of the pokemon.
     */
    private String name;
    /**
     * Available attacks of the pokemon.
     */
    private ArrayList<IAttack> attacks;
    /**
     * Available energies of the pokemon. Each key store a list with some type of energy.
     * There exists the next types of energies: ElectricEnergies, FireEnergies, FighterEnergies,
     * GrassEnergies, PsychicEnergies and WaterEnergies.
     */
    public HashMap<String, ArrayList<IEnergy>> energyAvailable;
    /**
     * Selected attack of the pokemon. The pokemon will attack with the selected attack. And it could be
     * changed from one of the attacks.
     */
    private IAttack selectedAttack;

    /**
     * The id of the pokemon in the pokedex.
     */
    private int id;

    /** Abstract constructor for the IPokemon type. It needs to be specified with the minimal definition of a
     * pokemon.
     * @param hp Hit points of the pokemon.
     * @param name Name of the pokemon.
     * @param attacks Attacks of the pokemon.
     */
    AbstractPokemon(int hp, String name, int id, ArrayList<IAttack> attacks){
        this.hp = hp;
        this.name = name;
        this.attacks = attacks;
        this.selectAttack(0);
        this.energyAvailable =  new HashMap<>();
        this.id = id;

        this.energyAvailable.put("GrassEnergies", new ArrayList<>());
        this.energyAvailable.put("FireEnergies", new ArrayList<>());
        this.energyAvailable.put("FighterEnergies", new ArrayList<>());
        this.energyAvailable.put("ElectricEnergies", new ArrayList<>());
        this.energyAvailable.put("PsychicEnergies", new ArrayList<>());
        this.energyAvailable.put("WaterEnergies", new ArrayList<>());
    }

    /** Getter for the pokemon's name.
     * @return The name of the pokemon.
     */
    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public String getInfo() {
        return "Nombre: " + this.getName() + ", Tipo: Pokemon, Id: " + this.getId();
    }

    /**
     * Method that adds this pokemon to some trainer bench.
     * @param trainer The trainer with the bench where this pokemon will be added.
     */
    @Override
    public void play(ITrainer trainer) {
        trainer.addPokemon(this);
    }

    /** Getter for the hit points of the pokemon.
     * @return The hp of the pokemon.
     */
    @Override
    public int getHp(){
        return this.hp;
    }

    /** Method to make specific damage to this pokemon.
     * @param damage Amount of damage that wants to be made.
     */
    @Override
    public void makeDamage(int damage) {
        if (damage >= 0) {
            this.hp -= damage;
            if (this.hp <= 0)
                this.hp = 0;
        }

    }

    /** Method that checks if the pokemon is death.
     * @return True if the pokemon is death.
     */
    @Override
    public boolean isDead() {
        return hp <= 0;
    }

    /**
     * Getter for the id of the pokemon.
     * @return The id of the pokemon
     */
    @Override
    public int getId() {
        return this.id;
    }

    /** Getter for the available energies.
     * @return A HashMap which keys are the type of energy and the value a list with the energies.
     */
    @Override
    public HashMap<String, ArrayList<IEnergy>> getEnergyHash() {
        return this.energyAvailable;
    }

    /** Getter for the pokemon attacks.
     * @return An ArrayList with a copy of the pokemon attacks.
     */
    @Override
    public ArrayList<IAttack> getAttacks(){
        return new ArrayList<>(this.attacks);
    }

    /** Getter for the selected attack.
     * @return The selected pokemon IAttack.
     */
    @Override
    public IAttack getSelectedAttack() {
        return selectedAttack;
    }

    /** Method for select an attack from the pokemon attacks. The option is a positional positive integer.
     * If the selection is the attack 0 the selectedAttack will be replaced with the
     *  0th attack from the pokemon attacks.
     * @param option Integer with the positional wanted attack.
     */
    @Override
    public void selectAttack(int option) {
        if (!(option < 0 || option > this.getAttacks().size()-1)){
            this.selectedAttack = this.attacks.get(option);
        }

    }

    /** Method to make damage to this pokemon from a FireAttack.
     * @param attack A FireAttack.
     */
    public void receiveFireAttack(FireAttack attack) {
        makeDamage(attack.getBaseDamage());
    }

    /** Method to make damage to this pokemon from a WaterAttack.
     * @param attack A WaterAttack.
     */
    public void receiveWaterAttack(WaterAttack attack) {
        makeDamage(attack.getBaseDamage());
    }

    /** Method to make damage to this pokemon from a GrassAttack.
     * @param attack A GrassAttack.
     */
    public void receiveGrassAttack(GrassAttack attack) {
        makeDamage(attack.getBaseDamage());
    }

    /** Method to make damage to this pokemon from a ElectricAttack.
     * @param attack A ElectricAttack.
     */
    public void receiveElectricAttack(ElectricAttack attack) {
        makeDamage(attack.getBaseDamage());
    }

    /** Method to make damage to this pokemon from a PsychicAttack.
     * @param attack A PsychicAttack.
     */
    public void receivePsychicAttack(PsychicAttack attack) {
        makeDamage(attack.getBaseDamage());

    }

    /** Method to make damage to this pokemon from a FighterAttack.
     * @param attack A FighterAttack.
     */
    public void receiveFighterAttack(FighterAttack attack) {
        makeDamage(attack.getBaseDamage());
    }

    /** Method to make damage to this pokemon from a NormalAttack.
     * @param attack A NormalAttack.
     */
    public void receiveNormalAttack(NormalAttack attack) {
        makeDamage(attack.getBaseDamage());
    }

    /** Method to assign a FireEnergy to this pokemon.
     * @param energy A FireEnergy.
     */
    public void receiveFireEnergy(FireEnergy energy) {
        ArrayList<IEnergy> energies = this.energyAvailable.get("FireEnergies");
        energies.add(energy);
        this.energyAvailable.replace("FireEnergies", energies);
    }

    /** Method to assign a ElectricEnergy to this pokemon.
     * @param energy A ElectricEnergy.
     */
    public void receiveElectricEnergy(ElectricEnergy energy) {
        ArrayList<IEnergy> energies = this.energyAvailable.get("ElectricEnergies");
        energies.add(energy);
        this.energyAvailable.replace("ElectricEnergies", energies);
    }

    /** Method to assign a GrassEnergy to this pokemon.
     * @param energy A GrassEnergy.
     */
    public void receiveGrassEnergy(GrassEnergy energy) {
        ArrayList<IEnergy> energies = this.energyAvailable.get("GrassEnergies");
        energies.add(energy);
        this.energyAvailable.replace("GrassEnergies", energies);
    }

    /** Method to assign a PsychicEnergy to this pokemon.
     * @param energy A PsychicEnergy.
     */
    public void receivePsychicEnergy(PsychicEnergy energy) {
        ArrayList<IEnergy> energies = this.energyAvailable.get("PsychicEnergies");
        energies.add(energy);
        this.energyAvailable.replace("PsychicEnergies", energies);
    }

    /** Method to assign a FighterEnergy to this pokemon.
     * @param energy A FighterEnergy.
     */
    public void receiveFighterEnergy(FighterEnergy energy) {
        ArrayList<IEnergy> energies = this.energyAvailable.get("FighterEnergies");
        energies.add(energy);
        this.energyAvailable.replace("FighterEnergies", energies);
    }

    /** Method to assign a WaterEnergy to this pokemon.
     * @param energy A WaterEnergy.
     */
    public void receiveWaterEnergy(WaterEnergy energy) {
        ArrayList<IEnergy> energies = this.energyAvailable.get("WaterEnergies");
        energies.add(energy);
        this.energyAvailable.replace("WaterEnergies", energies);

    }

}
