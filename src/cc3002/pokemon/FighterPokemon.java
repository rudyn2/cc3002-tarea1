package cc3002.pokemon;

import cc3002.attack.GrassAttack;
import cc3002.attack.IAttack;
import cc3002.attack.PsychicAttack;

import java.util.ArrayList;

public class FighterPokemon extends AbstractPokemon {

    FighterPokemon(int hp, String name, ArrayList<IAttack> attacks) {
        super(hp, name, attacks);
    }

    @Override
    public void receiveGrassAttack(GrassAttack attack) {
        this.hp -= attack.getBaseDamage()*2;
    }

    @Override
    public void receivePsychicAttack(PsychicAttack attack) {
        this.hp -= attack.getBaseDamage()*2;
    }
}
