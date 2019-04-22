package cc3002.pokemon;

import cc3002.attack.*;
import cc3002.energy.*;

import java.util.ArrayList;
import java.util.HashMap;

public interface IPokemon {
    String getName();

    /**
     * Obtiene la cantidad de puntos del pokemon
     * @return puntos de vida del pokemon [int]
     */
    int getHp();
    boolean isDead();
    HashMap<String, ArrayList<IEnergy>> getEnergyHash();
    ArrayList<IAttack> getAttacks();

    // Receive different types of attacks
    void receiveFireAttack(FireAttack attack);
    void receiveWaterAttack(WaterAttack attack);
    void receiveGrassAttack(GrassAttack attack);
    void receiveElectricAttack(ElectricAttack attack);
    void receivePsychicAttack(PsychicAttack attack);
    void receiveFighterAttack(FighterAttack attack);
    void receiveNormalAttack(NormalAttack attack);

    // Receive different types of energies
    void receiveFireEnergy(FireEnergy energy);
    void receiveElectricEnergy(ElectricEnergy energy);
    void receiveGrassEnergy(GrassEnergy energy);
    void receivePsychicEnergy(PsychicEnergy energy);
    void receiveFighterEnergy(FighterEnergy energy);
    void receiveWaterEnergy(WaterEnergy energy);

}
