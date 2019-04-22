package cc3002.pokemon;

import cc3002.attack.ElectricAttack;
import cc3002.attack.FighterAttack;
import cc3002.attack.GrassAttack;
import cc3002.attack.IAttack;

import java.util.ArrayList;

public class WaterPokemon extends AbstractPokemon {
    WaterPokemon(int hp, String name, ArrayList<IAttack> attacks) {
        super(hp, name, attacks);
    }

    @Override
    public void receiveGrassAttack(GrassAttack attack) {
        this.hp -= attack.getBaseDamage()*2;
    }

    @Override
    public void receiveElectricAttack(ElectricAttack attack) {
        this.hp -= attack.getBaseDamage()*2;
    }

    @Override
    public void receiveFighterAttack(FighterAttack attack) {
        this.hp -= (attack.getBaseDamage()-30);
    }
}
