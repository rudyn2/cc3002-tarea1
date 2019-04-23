package cc3002.attack;

import cc3002.energy.IEnergy;
import cc3002.pokemon.*;

import java.util.ArrayList;

public abstract class AbstractAttack implements IAttack {

    private String name;
    private String description;
    private int baseDamage;
    private int cost;

    AbstractAttack(String name, String description, int baseDamage, int cost){
        this.name = name;
        this.description = description;
        this.baseDamage = baseDamage;
        this.cost = cost;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCost() {
        return this.cost;
    }

    @Override
    public String getDescription(){
        return this.description;
    }

    @Override
    public int getBaseDamage() {
        return this.baseDamage;
    }

    public int countEnergy(ArrayList<IEnergy> energies){
        int energyCount = 0;
        if (energies.size() > 0) {
            for(IEnergy e : energies) {
                energyCount += e.getBaseEnergy();
            }
        }
        return energyCount;
    }


    @Override
    public boolean checkFireEnergy(FirePokemon pokemon) {
        ArrayList<IEnergy> energies = pokemon.energyAvailable.get("FireEnergies");
        return this.countEnergy(energies) > this.cost;

    }

    @Override
    public boolean checkElectricEnergy(ElectricPokemon pokemon) {
        ArrayList<IEnergy> energies = pokemon.energyAvailable.get("ElectricEnergies");
        return this.countEnergy(energies) > this.cost;
    }

    @Override
    public boolean checkFighterEnergy(FighterPokemon pokemon) {
        ArrayList<IEnergy> energies = pokemon.energyAvailable.get("FighterEnergies");
        return this.countEnergy(energies) > this.cost;
    }

    @Override
    public boolean checkGrassEnergy(GrassPokemon pokemon) {
        ArrayList<IEnergy> energies = pokemon.energyAvailable.get("GrassEnergies");
        return this.countEnergy(energies) > this.cost;
    }

    @Override
    public boolean checkPsychicEnergy(PsychicPokemon pokemon) {
        ArrayList<IEnergy> energies = pokemon.energyAvailable.get("PsychicEnergies");
        return this.countEnergy(energies) > this.cost;
    }

    @Override
    public boolean checkWaterEnergy(WaterPokemon pokemon) {
        ArrayList<IEnergy> energies = pokemon.energyAvailable.get("WaterEnergies");
        return this.countEnergy(energies) > this.cost;
    }

}
