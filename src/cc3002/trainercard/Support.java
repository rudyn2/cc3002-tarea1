package cc3002.trainercard;

import cc3002.effect.InstantEffect;
import cc3002.visitor.IVisitor;

public class Support extends AbstractTrainerCard {
    public Support(String name, InstantEffect effect) {
        super(name, effect);
    }

    @Override
    public void accept(IVisitor v) {
        v.visitSupport(this);
    }
}
