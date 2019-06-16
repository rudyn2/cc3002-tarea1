package cc3002.pokemon;

import cc3002.attack.GrassAttack;
import cc3002.attack.IAbility;
import cc3002.attack.IAttack;
import cc3002.attack.PsychicAttack;

import java.util.ArrayList;

public class FighterPokemon extends AbstractPokemon {


    public FighterPokemon(int hp, String name, int id, ArrayList<IAttack> attacks, ArrayList<IAbility> abilities) {
        super(hp, name, id, attacks, abilities);
    }

    @Override
    public boolean checkEnergy() {
        return this.getSelectedAttack().checkFighterEnergy(this);
    }

    @Override
    public void receiveGrassAttack(GrassAttack attack) {
        this.makeDamage(attack.getBaseDamage()*2);
    }

    @Override
    public void receivePsychicAttack(PsychicAttack attack) {
        this.makeDamage(attack.getBaseDamage()*2);
    }
}
