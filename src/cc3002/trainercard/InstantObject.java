package cc3002.trainercard;

import cc3002.effect.InstantEffect;
import cc3002.pokemon.IPokemon;
import cc3002.visitor.IVisitor;

public class InstantObject extends AbstractTrainerCard {

    public InstantObject(String name, InstantEffect effect) {
        super(name, effect);
    }


    @Override
    public void accept(IVisitor v) {
        v.visitInstantObject(this);
    }
}
