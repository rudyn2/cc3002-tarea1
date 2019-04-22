package cc3002.pokemon;

import cc3002.attack.*;
import cc3002.energy.*;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractPokemon implements IPokemon {

    protected int hp;
    private String name;
    private ArrayList<IAttack> attacks;
    private int damageCounter;
    private HashMap<String, ArrayList<IEnergy>> energyAvailable;

    AbstractPokemon(int hp, String name, ArrayList<IAttack> attacks){
        this.hp = hp;
        this.name = name;
        this.attacks = attacks;
        this.damageCounter = 0;
        this.energyAvailable =  new HashMap<>();

        // Init the initial energy as 0 for all the fields
        this.energyAvailable.put("GrassEnergies", new ArrayList<>());
        this.energyAvailable.put("FireEnergies", new ArrayList<>());
        this.energyAvailable.put("ElectricEnergies", new ArrayList<>());
        this.energyAvailable.put("PsychicEnergies", new ArrayList<>());
        this.energyAvailable.put("WaterEnergies", new ArrayList<>());
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public int getHp(){
        return this.hp;
    }

    @Override
    public boolean isDead() {
        return damageCounter >= hp;
    }

    @Override
    public HashMap<String, ArrayList<IEnergy>> getEnergyHash() {
        return this.energyAvailable;
    }

    @Override
    public ArrayList<IAttack> getAttacks(){
        return this.attacks;
    }

    @Override
    public void receiveFireAttack(FireAttack attack) {
        this.hp -= attack.getBaseDamage();
    }

    @Override
    public void receiveWaterAttack(WaterAttack attack) {
        this.hp -= attack.getBaseDamage();
    }

    @Override
    public void receiveGrassAttack(GrassAttack attack) {
        this.hp -= attack.getBaseDamage();
    }

    @Override
    public void receiveElectricAttack(ElectricAttack attack) {
        this.hp -= attack.getBaseDamage();
    }

    @Override
    public void receivePsychicAttack(PsychicAttack attack) {
        this.hp -= attack.getBaseDamage();

    }

    @Override
    public void receiveFighterAttack(FighterAttack attack) {
        this.hp -= attack.getBaseDamage();
    }

    @Override
    public void receiveNormalAttack(NormalAttack attack) {
        this.hp -= attack.getBaseDamage();
    }

    @Override
    public void receiveFireEnergy(FireEnergy energy) {
        ArrayList<IEnergy> energies = this.energyAvailable.get("FireEnergies");
        energies.add(energy);
        this.energyAvailable.replace("FireEnergies", energies);
    }

    @Override
    public void receiveElectricEnergy(ElectricEnergy energy) {
        ArrayList<IEnergy> energies = this.energyAvailable.get("ElectricEnergies");
        energies.add(energy);
        this.energyAvailable.replace("ElectricEnergies", energies);
    }

    @Override
    public void receiveGrassEnergy(GrassEnergy energy) {
        ArrayList<IEnergy> energies = this.energyAvailable.get("GrassEnergies");
        energies.add(energy);
        this.energyAvailable.replace("GrassEnergies", energies);
    }

    @Override
    public void receivePsychicEnergy(PsychicEnergy energy) {
        ArrayList<IEnergy> energies = this.energyAvailable.get("PsychicEnergies");
        energies.add(energy);
        this.energyAvailable.replace("PsychicEnergies", energies);

    }

    @Override
    public void receiveFighterEnergy(FighterEnergy energy) {
        ArrayList<IEnergy> energies = this.energyAvailable.get("FighterEnergies");
        energies.add(energy);
        this.energyAvailable.replace("FighterEnergies", energies);

    }

    @Override
    public void receiveWaterEnergy(WaterEnergy energy) {
        ArrayList<IEnergy> energies = this.energyAvailable.get("WatereEnergies");
        energies.add(energy);
        this.energyAvailable.replace("WaterEnergies", energies);

    }

}
