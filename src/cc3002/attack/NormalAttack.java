package cc3002.attack;

import cc3002.pokemon.IPokemon;

public class NormalAttack extends AbstractAttack {

    public NormalAttack(String name, String description, int baseDamage, int cost) {
        super(name, description, baseDamage, cost);
    }

    @Override
    public void attack(IPokemon pokemon) {
        pokemon.receiveNormalAttack(this);
    }
}
