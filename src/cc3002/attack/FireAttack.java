package cc3002.attack;

import cc3002.pokemon.IPokemon;

public class FireAttack extends AbstractAttack {

    public FireAttack(String name, String description, int baseDamage, int cost){
        super(name, description, baseDamage, cost);
    }

    @Override
    public void attack(IPokemon pokemon) {
        pokemon.receiveFireAttack(this);
    }
}
