package cc3002.energy;

import cc3002.pokemon.IPokemon;

public class PsychicEnergy extends AbstractEnergy {
    public PsychicEnergy(String name, int baseEnergy) {
        super(name, baseEnergy);
    }

    @Override
    public void assignEnergy(IPokemon pokemon) {
        pokemon.receivePsychicEnergy(this);
    }
}
