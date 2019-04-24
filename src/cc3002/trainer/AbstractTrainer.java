package cc3002.trainer;

import cc3002.ICard;
import cc3002.pokemon.IPokemon;

import java.util.ArrayList;

public abstract class AbstractTrainer implements ITrainer {

    private String name;
    private IPokemon activePokemon;
    private  ArrayList<IPokemon> pokemons;
    private ArrayList<ICard> hand;

    AbstractTrainer(String name, ArrayList<ICard> handCards) {
        this(name, handCards, null,  new ArrayList<>());
    }

    AbstractTrainer(String name, ArrayList<ICard> handCards, IPokemon activePokemon){
        this(name, handCards, activePokemon, new ArrayList<>());
    }

    AbstractTrainer(String name, ArrayList<ICard> handCards, IPokemon activePokemon, ArrayList<IPokemon> initialPokemons){
        this.name = name;
        this.activePokemon = activePokemon;
        this.hand = handCards;
        this.pokemons = initialPokemons;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ArrayList<ICard> getHand() {
        return this.hand;
    }

    @Override
    public void selectAttackOfActivePokemon(int option) {
        this.activePokemon.selectAttack(option);
    }

    @Override
    public IPokemon getActivePokemon() {
        return this.activePokemon;
    }

    @Override
    public void changeActivePokemon(int option) {
        if (option < this.pokemons.size()){
            this.pokemons.add(this.activePokemon);
            this.activePokemon = this.pokemons.remove(option);
        }

    }

    @Override
    public boolean isOver() {
        return this.activePokemon.isDead() && this.pokemons.size() == 0;
    }


}
