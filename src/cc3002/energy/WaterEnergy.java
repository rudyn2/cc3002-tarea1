package cc3002.energy;

import cc3002.pokemon.IPokemon;

public class WaterEnergy extends AbstractEnergy {
    public WaterEnergy(String name, int baseEnergy) {
        super(name, baseEnergy);
    }

    @Override
    public void assignEnergy(IPokemon pokemon) {
        pokemon.receiveWaterEnergy(this);
    }
}
