package cc3002.trainer;

import cc3002.ICard;
import cc3002.pokemon.IPokemon;

import java.util.ArrayList;

public class NormalTrainer extends AbstractTrainer {

    public NormalTrainer(String name, ArrayList<ICard> handCards) {
        super(name, handCards);
    }

    public NormalTrainer(String name, ArrayList<ICard> handCards, IPokemon activePokemon) {
        super(name, handCards, activePokemon);
    }

    public NormalTrainer(String name, ArrayList<ICard> handCards, IPokemon activePokemon, ArrayList<IPokemon> initialPokemons) {
        super(name, handCards, activePokemon, initialPokemons);
    }
}
