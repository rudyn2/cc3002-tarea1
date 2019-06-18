package cc3002.pokemon;

import cc3002.attack.IAbility;
import cc3002.attack.IAttack;
import cc3002.attack.WaterAttack;

import java.util.ArrayList;

public abstract class AbstractFirePokemon extends AbstractPokemon{

    public AbstractFirePokemon(int hp, String name, int id, ArrayList<IAttack> attacks, ArrayList<IAbility> abilities) {
        super(hp, name, id, attacks, abilities);
    }

    @Override
    public void receiveWaterAttack(WaterAttack attack) {
        this.makeDamage(attack.getBaseDamage()*2);
    }

    @Override
    public boolean checkEnergy() {
        return this.getSelectedAttack().checkFireEnergy(this);
    }


}
