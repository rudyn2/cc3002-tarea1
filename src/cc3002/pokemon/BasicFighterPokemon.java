package cc3002.pokemon;

import cc3002.attack.IAbility;
import cc3002.attack.IAttack;
import cc3002.trainer.ITrainer;

import java.util.ArrayList;

public class BasicFighterPokemon extends AbstractFighterPokemon {
    public BasicFighterPokemon(int hp, String name, int id, ArrayList<IAttack> attacks, ArrayList<IAbility> abilities) {
        super(hp, name, id, attacks, abilities);
    }

    @Override
    public boolean play(ITrainer trainer) {
        return trainer.addBasicPokemon(this);
    }

    @Override
    public boolean checkBasic() {
        return true;
    }
}
