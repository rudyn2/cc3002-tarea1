package cc3002.pokemon;

import cc3002.attack.FighterAttack;
import cc3002.attack.IAbility;
import cc3002.attack.IAttack;
import cc3002.attack.PsychicAttack;

import java.util.ArrayList;

public class PsychicPokemon extends AbstractPokemon {

    public PsychicPokemon(int hp, String name, int id, ArrayList<IAttack> attacks, ArrayList<IAbility> abilities) {
        super(hp, name, id, attacks, abilities);
    }

    @Override
    public boolean checkEnergy() {
        return this.getSelectedAttack().checkPsychicEnergy(this);
    }

    @Override
    public void receivePsychicAttack(PsychicAttack attack) {
        this.makeDamage(attack.getBaseDamage()*2);
    }

    @Override
    public void receiveFighterAttack(FighterAttack attack) {
        this.makeDamage(attack.getBaseDamage()-30);
    }
}
