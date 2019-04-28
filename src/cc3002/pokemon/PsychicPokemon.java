package cc3002.pokemon;

import cc3002.attack.FighterAttack;
import cc3002.attack.IAttack;
import cc3002.attack.PsychicAttack;

import java.util.ArrayList;

public class PsychicPokemon extends AbstractPokemon {
    public PsychicPokemon(int hp, String name, int id, ArrayList<IAttack> attacks) {
        super(hp, name, id, attacks);
    }

    @Override
    public void attack(IPokemon pokemon) {
        if (this.getSelectedAttack().checkPsychicEnergy(this)) {
            this.getSelectedAttack().attack(pokemon);
            System.out.println(this.getName() + " ha atacado a " + pokemon.getName());
        }
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
