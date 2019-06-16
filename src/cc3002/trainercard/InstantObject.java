package cc3002.trainercard;

import cc3002.effect.InstantEffect;
import cc3002.pokemon.IPokemon;
import cc3002.visitor.IVisitor;

public class InstantObject extends AbstractTrainerCard {


    public IPokemon getTarget() {
        return target;
    }

    /**
     * This field specifies if the object needs some target.
     */
    private IPokemon target;

    public InstantObject(String name, InstantEffect effect, IPokemon target) {
        super(name, effect);
        this.target = target;
    }


    @Override
    public void accept(IVisitor v) {
        v.visitInstantObject(this);
    }
}
