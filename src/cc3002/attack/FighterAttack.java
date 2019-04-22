package cc3002.attack;

import cc3002.pokemon.IPokemon;

public class FighterAttack extends AbstractAttack {
    public FighterAttack(String name, String description, int baseDamage, int cost) {
        super(name, description, baseDamage, cost);
    }

    @Override
    public void attack(IPokemon pokemon) {
        pokemon.receiveFighterAttack(this);

    }
}
