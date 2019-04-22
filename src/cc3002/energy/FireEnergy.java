package cc3002.energy;

import cc3002.pokemon.IPokemon;

public class FireEnergy extends AbstractEnergy {
    public FireEnergy(String name, int baseEnergy) {
        super(name, baseEnergy);
    }

    @Override
    public void assignEnergy(IPokemon pokemon) {
        pokemon.receiveFireEnergy(this);
    }
}
