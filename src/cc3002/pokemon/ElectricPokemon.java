package cc3002.pokemon;

import cc3002.attack.*;

import java.util.ArrayList;

public class ElectricPokemon extends AbstractPokemon {

    public ElectricPokemon(int hp, String name, int id, ArrayList<IAttack> attacks, ArrayList<IAbility> abilities) {
        super(hp, name, id, attacks, abilities);
    }

    @Override
    public void receiveWaterAttack(WaterAttack attack) {
        super.receiveWaterAttack(attack);
    }

    @Override
    public void receiveFighterAttack(FighterAttack attack) {
        this.makeDamage(attack.getBaseDamage()*2);
    }

    @Override
    public boolean checkEnergy() {
        return this.getSelectedAttack().checkElectricEnergy(this);
    }

}
