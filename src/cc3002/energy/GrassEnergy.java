package cc3002.energy;

import cc3002.pokemon.IPokemon;

public class GrassEnergy extends AbstractEnergy {

    public GrassEnergy(String name, int baseEnergy) {
        super(name, baseEnergy);
    }

    @Override
    public void assignEnergy(IPokemon pokemon) {
        pokemon.receiveGrassEnergy(this);
    }
}
