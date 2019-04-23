package cc3002.trainer;

import cc3002.pokemon.IPokemon;

import java.util.ArrayList;

public class AbstractTrainer implements ITrainer {

    private String name;
    private IPokemon activePokemon;
    private ArrayList<IPokemon> pokemons;

    AbstractTrainer(String name, ArrayList<IPokemon> pokemons){
        this.name = name;
        this.pokemons = pokemons;

    }

    @Override
    public String getName() {
        return this.name;
    }
}
