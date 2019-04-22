package cc3002.energy;

import cc3002.pokemon.IPokemon;

public class FighterEnergy extends AbstractEnergy {
    public FighterEnergy(String name, int baseEnergy) {
        super(name, baseEnergy);
    }

    @Override
    public void assignEnergy(IPokemon pokemon) {
        pokemon.receiveFighterEnergy(this);
    }
}
