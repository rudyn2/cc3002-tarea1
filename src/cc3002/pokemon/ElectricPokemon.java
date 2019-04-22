package cc3002.pokemon;

import cc3002.attack.FighterAttack;
import cc3002.attack.IAttack;
import cc3002.attack.WaterAttack;

import java.util.ArrayList;

public class ElectricPokemon extends AbstractPokemon {

    ElectricPokemon(int hp, String name, ArrayList<IAttack> attacks) {
        super(hp, name, attacks);
    }

    @Override
    public void receiveWaterAttack(WaterAttack attack) {
        super.receiveWaterAttack(attack);
    }

    @Override
    public void receiveFighterAttack(FighterAttack attack) {
        this.hp -= attack.getBaseDamage()*2;
    }

}
