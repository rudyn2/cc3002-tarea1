package cc3002.energy;

import cc3002.pokemon.IPokemon;

public interface IEnergy {

    String getName();
    int getBaseEnergy();
    void assignEnergy(IPokemon pokemon);

}
