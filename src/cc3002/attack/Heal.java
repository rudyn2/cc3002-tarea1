package cc3002.attack;

import cc3002.effect.InstantEffect;
import cc3002.game.GameDriver;
import cc3002.pokemon.IPokemon;
import cc3002.visitor.IVisitor;

public class Heal extends AbstractAbility {


    public Heal(String name, String description, InstantEffect effect) {
        super(name, description, effect);
    }

    @Override
    public void accept(IVisitor v) {
        v.visitAbility(this);
    }


}
