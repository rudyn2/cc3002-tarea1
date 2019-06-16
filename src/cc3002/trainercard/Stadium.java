package cc3002.trainercard;

import cc3002.effect.Effect;
import cc3002.visitor.IVisitor;

public class Stadium extends AbstractTrainerCard {

    public Stadium(String name, Effect effect) {
        super(name, effect);
    }

    @Override
    public void accept(IVisitor v) {
        v.visitStadium(this);
    }
}
