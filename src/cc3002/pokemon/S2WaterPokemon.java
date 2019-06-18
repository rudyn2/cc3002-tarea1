package cc3002.pokemon;

import cc3002.attack.IAbility;
import cc3002.attack.IAttack;
import cc3002.trainer.ITrainer;

import java.util.ArrayList;

public class S2WaterPokemon extends AbstractWaterPokemon {
    public S2WaterPokemon(int hp, String name, int id, ArrayList<IAttack> attacks, ArrayList<IAbility> abilities) {
        super(hp, name, id, attacks, abilities);
    }

    @Override
    public boolean play(ITrainer trainer) {
        return trainer.addS2Pokemon(this);
    }

    @Override
    public boolean checkS2() {
        return true;
    }
}
