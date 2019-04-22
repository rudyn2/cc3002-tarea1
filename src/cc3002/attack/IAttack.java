package cc3002.attack;

import cc3002.pokemon.IPokemon;

public interface IAttack {

    void attack(IPokemon pokemon);
    String getDescription();
    String getName();
    int getCost();
    int getBaseDamage();

}
