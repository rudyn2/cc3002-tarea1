package cc3002.energy;

import cc3002.pokemon.IPokemon;

public class ElectricEnergy extends AbstractEnergy {

    public ElectricEnergy(String name, int baseEnergy) {
        super(name, baseEnergy);
    }

    @Override
    public void assignEnergy(IPokemon pokemon) {
        pokemon.receiveElectricEnergy(this);
    }
}
