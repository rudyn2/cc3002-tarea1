package cc3002.pokemon;

import cc3002.attack.*;

import java.util.ArrayList;

public abstract class AbstractWaterPokemon extends AbstractPokemon {
    public AbstractWaterPokemon(int hp, String name, int id, ArrayList<IAttack> attacks, ArrayList<IAbility> abilities) {
        super(hp, name, id, attacks, abilities);
    }

    @Override
    public void receiveGrassAttack(GrassAttack attack) {
        this.makeDamage(attack.getBaseDamage()*2);
    }

    @Override
    public boolean checkEnergy() {
        return this.getSelectedAttack().checkWaterEnergy(this);
    }

    @Override
    public void receiveElectricAttack(ElectricAttack attack) {
        this.makeDamage(attack.getBaseDamage()*2);
    }

    @Override
    public void receiveFighterAttack(FighterAttack attack) {
        this.makeDamage(attack.getBaseDamage()-30);
    }
}
