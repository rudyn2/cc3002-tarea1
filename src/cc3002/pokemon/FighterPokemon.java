package cc3002.pokemon;

import cc3002.attack.GrassAttack;
import cc3002.attack.IAttack;
import cc3002.attack.PsychicAttack;

import java.util.ArrayList;

public class FighterPokemon extends AbstractPokemon {

    public FighterPokemon(int hp, String name, int id, ArrayList<IAttack> attacks) {
        super(hp, name, id, attacks);
    }

    @Override
    public void attack(IPokemon pokemon) {
        if (this.getSelectedAttack().checkFighterEnergy(this)) {
            this.getSelectedAttack().attack(pokemon);
            System.out.println(this.getName() + " ha atacado a " + pokemon.getName());
        }
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
