package cc3002.pokemon;

import cc3002.attack.FireAttack;
import cc3002.attack.IAbility;
import cc3002.attack.IAttack;
import cc3002.attack.WaterAttack;

import java.util.ArrayList;

public abstract class AbstractGrassPokemon extends AbstractPokemon {

    public AbstractGrassPokemon(int hp, String name, int id, ArrayList<IAttack> attacks, ArrayList<IAbility> abilities) {
        super(hp, name, id, attacks, abilities);
    }

    @Override
    public boolean checkEnergy() {
        return this.getSelectedAttack().checkGrassEnergy(this);
    }

    @Override
    public void receiveFireAttack(FireAttack attack) {
        this.makeDamage(attack.getBaseDamage()*2);
    }

    @Override
    public void receiveWaterAttack(WaterAttack attack) {
        this.makeDamage(attack.getBaseDamage() - 30);
    }
}
