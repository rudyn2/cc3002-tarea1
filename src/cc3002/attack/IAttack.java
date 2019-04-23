package cc3002.attack;

import cc3002.pokemon.*;

public interface IAttack {

    void attack(IPokemon pokemon);
    String getDescription();
    String getName();
    int getCost();
    int getBaseDamage();

    boolean checkFireEnergy(FirePokemon pokemon);
    boolean checkElectricEnergy(ElectricPokemon pokemon);
    boolean checkFighterEnergy(FighterPokemon pokemon);
    boolean checkGrassEnergy(GrassPokemon pokemon);
    boolean checkPsychicEnergy(PsychicPokemon pokemon);
    boolean checkWaterEnergy(WaterPokemon pokemon);
}
