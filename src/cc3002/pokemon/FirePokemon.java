package cc3002.pokemon;

import cc3002.attack.IAttack;
import cc3002.attack.WaterAttack;

import java.util.ArrayList;

public class FirePokemon extends AbstractPokemon{

    FirePokemon(int hp, String name, ArrayList<IAttack> attacks){
        super(hp, name, attacks);
    }

    @Override
    public void receiveWaterAttack(WaterAttack attack) {
        this.hp -= attack.getBaseDamage()*2;
    }


}
