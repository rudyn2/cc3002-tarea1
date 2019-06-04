package cc3002.pokemon;

import cc3002.attack.FireAttack;
import cc3002.attack.IAttack;
import cc3002.attack.WaterAttack;

import java.util.ArrayList;

public class GrassPokemon extends AbstractPokemon {
    public GrassPokemon(int hp, String name, int id, ArrayList<IAttack> attacks) {
        super(hp, name, id, attacks);
    }

    @Override
    public void attack(IPokemon pokemon) {
        if (this.getSelectedAttack().checkGrassEnergy(this)) {
            this.getSelectedAttack().attack(pokemon);
        }
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
